// mkdir sbt-stream1
// cd sbt-stream1
// vi build.sbt
// sbt
// Update build.sbt, Create src/main/scala/example
// Create file src/main/scala/example/StreamingApp.scala
// sbt compile
// sbt package
// ~/spark-2.4.7-bin-hadoop2.7/bin/spark-submit --class "example.StreamingApp" --master local[*] target/scala-2.11/streaming-project_2.11-1.0.jar
// nc -lk 9999
// 
//  ~/spark-2.4.7-bin-hadoop2.7/bin/spark-submit --class "example.HdfsBatchWordCount" --master local[*] target/scala-2.11/streaming-project_2.11-1.0.jar
//
// 
name := "Streaming Project"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.7"
libraryDependencies += "org.apache.spark" % "spark-streaming_2.11" % "2.4.7" % "provided"
