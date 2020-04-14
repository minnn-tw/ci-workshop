plugins {
    kotlin("jvm") version "1.3.71"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.sparkjava:spark-kotlin:1.0.0-alpha")
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}