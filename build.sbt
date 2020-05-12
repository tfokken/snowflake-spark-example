name := "spark-examples"
version := "0.1"
scalaVersion := "2.12.11"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "2.4.5",
  "net.snowflake" %% "spark-snowflake" % "2.7.0-spark_2.4"
)
