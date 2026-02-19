plugins {
    id("java")
    id("io.qameta.allure") version "3.0.2"
}

group = "com.github.anastasiia-smotritskaya"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("io.rest-assured:rest-assured:6.0.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.21.0")
    implementation("io.qameta.allure:allure-gradle:2.8.1")
}

tasks.test {
    useJUnitPlatform()
}