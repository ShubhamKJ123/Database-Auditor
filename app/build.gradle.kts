plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
    implementation("com.google.guava:guava:31.1-jre")
    implementation("org.postgresql:postgresql:42.5.3")
    implementation("io.github.cdimascio:dotenv-java:2.3.2")
    implementation ("org.neo4j.driver:neo4j-java-driver:5.6.0")
}

application {
    mainClass.set("databaseauditor.App")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
