plugins {
    id("java")
}

group = "org.lostway"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
}

java {
    withJavadocJar()
    withSourcesJar()
}