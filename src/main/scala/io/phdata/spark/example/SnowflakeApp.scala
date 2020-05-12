package io.phdata.spark.example

import org.apache.spark.sql.{SaveMode, SparkSession}
import net.snowflake.spark.snowflake.Utils.SNOWFLAKE_SOURCE_NAME

class SnowflakeApp {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("Snowflake Example").getOrCreate()

    val df = spark.read.parquet("<path to parquet dataset>")

    val sfOps = Map(
      "sfUrl" -> "<account_name>",
      "sfUser" -> "<user_name>",
      "sfPassword" -> "<password>",
      "sfDatabase" -> "<database>",
      "sfSchema" -> "<schema>",
      "sfWarehouse" -> "<warehouse>"
    )
    df.write
      .format(SNOWFLAKE_SOURCE_NAME)
      .options(sfOps)
      .option("dbtable", "<table name>")
      .mode(SaveMode.Append)
      .save()

  }
}
