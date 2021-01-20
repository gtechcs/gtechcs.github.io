/**
 * 
 * Run as
 * sbt compile
 * sbt package
 *  ~/spark-2.4.7-bin-hadoop2.7/bin/spark-submit --class "example.IntuitDemo" --master local[*] target/scala-2.11/streaming-project_2.11-1.0.jar
 */
package example

import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._ // not necessary since Spark 1.3
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions

object IntuitDemo {
  def main(args: Array[String]) {
    val sparkConf = new SparkConf().setAppName("IntuitDemo")
    val sc = new SparkContext(sparkConf)
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)

    val univDF = sqlContext.read.option("header", true).csv("/Users/p0k00nx/kaggle/Universities_Global_Ranking.csv")
    val univSelectedDF = univDF.select(univDF("world_rank"), univDF("institution"),univDF("year") )
    val univFilteredDF = univSelectedDF.filter(univSelectedDF("year") === "2015")// Optimisated Hard coded
    //    univFilteredDF.show(10)
    
    val collegesDF = sqlContext.read.option("header", true).csv("/Users/p0k00nx/kaggle/College_Admissions.csv")
    val collegesAddedDF = collegesDF.select(collegesDF("Name"), collegesDF("Applicants total"), collegesDF("Admissions Total"), collegesDF("State abbreviation"))
    val cDF1 = collegesAddedDF.withColumnRenamed("Applicants total", "ApplicantsTotal")
    val cDF2 = cDF1.withColumnRenamed("Admissions Total", "AdmissionsTotal")
    val collegesSelectedDF = cDF2.withColumnRenamed("State abbreviation", "State")
//    collegesSelectedDF.show(10)
        
//    Use Case 1: Save as Parquet
//    val joinedDF = univFilteredDF.join(collegesSelectedDF,univFilteredDF("institution") === collegesSelectedDF("Name"), "left")
//    val joinedWithCol = joinedDF.withColumn("world_rank_id", joinedDF("world_rank").cast(IntegerType))
//    joinedWithCol.show(10)
//    joinedWithCol.write.parquet("/Users/p0k00nx/kaggle/UniversitiesRanked_parquet")

    //Use Case 2: group By State
    val joinedDF = univFilteredDF.join(collegesSelectedDF,univFilteredDF("institution") === collegesSelectedDF("Name"))
    val joinedWithCol = joinedDF.withColumn("world_rank_id", joinedDF("world_rank").cast(IntegerType))
    val joinOrderedDF = joinedWithCol.sort(joinedWithCol("State"), joinedWithCol("world_rank_id"))
    //joinOrderedDF.show(150)
    joinOrderedDF.write.orc("/Users/p0k00nx/kaggle/UniversitiesRankedByState_orc")

  }
}

