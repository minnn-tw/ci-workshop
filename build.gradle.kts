plugins {
    kotlin("jvm") version "1.3.71"
    distribution
    application
}

application {
    mainClassName = "TestApp"
}

repositories {
    mavenCentral()
    jcenter()
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.sparkjava:spark-kotlin:1.0.0-alpha")
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
    testImplementation("io.kotest:kotest-runner-junit5-jvm:4.0.3")
    testImplementation("io.kotest:kotest-assertions-core-jvm:4.0.3")
}