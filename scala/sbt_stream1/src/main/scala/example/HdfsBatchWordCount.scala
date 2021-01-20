package example

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.{Seconds, StreamingContext}


object HdfsBatchWordCount {
  def main(args: Array[String]) {

    val sparkConf = new SparkConf().setAppName("HdfsBatchWordCount")
    val sc = new SparkContext(sparkConf)
    var lines = sc.textFile("hdfs://localhost:9000/user/part-00000") 

    val words = lines.flatMap(_.split(",")) // .reduceByKey( (a,b) => a+b)
    val wordCounts = words.map(x => (x, 1)).reduceByKey(_ + _)
    val wordCountsFiltered = wordCounts.filter{ case (key, value) => value != 1}
    wordCountsFiltered.foreach(println)
    
  }
}
