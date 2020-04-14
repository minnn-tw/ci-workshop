import spark.kotlin.*

class Application

fun main(args: Array<String>) {
    val http: Http = ignite()

    http.get("/hello") {
        "Hello Spark Kotlin!"
    }
}