package example

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.{Seconds, StreamingContext}


object HdfsLocalWordCount {
  def main(args: Array[String]) {
//    if (args.length < 1) {
//      System.err.println("Usage: HdfsWordCount <directory>")
//      System.exit(1)
//    }

    val sparkConf = new SparkConf().setAppName("HdfsLocalWordCount")
    // Create the context
    val sc = new SparkContext(sparkConf)
    
    val linesList = scala.io.Source.fromFile("/Users/p0k00nx/tmp/test.txt").getLines.toList
    val lines = sc.parallelize(linesList)

    val words = lines.flatMap(_.split(" "))
//    val wordCounts = words.map(x => (x, 1)).reduceByKey(_ + _)
    val wordCounts = words.map(x => (x, 1)).reduceByKey( (a,b) => a+b)

    wordCounts.foreach(println)
    
  }
}
