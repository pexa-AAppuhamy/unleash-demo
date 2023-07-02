import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    id("org.springframework.boot") version "3.0.4"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
    kotlin("plugin.jpa") version "1.8.22"
    id("org.openapi.generator") version "6.6.0"
}

group = "com.unleashdemo"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

openApiGenerate {
    generatorName.set("kotlin-spring")
    inputSpec.set("$rootDir/src/main/resources/static/unleash.spec.yaml")
    outputDir.set("$buildDir/generated/")
    apiPackage.set("com.unleashdemo.backend.common.controller")
    modelPackage.set("com.unleashdemo.backend.common.model")
    groupId.set("com.unleashdemo")
    configOptions.set(mapOf("useSpringBoot3" to "true",
        "delegatePattern" to "true",
        "apiSuffix" to "",
        "useTags" to "true",
        "exceptionHandler" to "false",
        "enumPropertyNaming" to "UPPERCASE",
        "swaggerAnnotations" to "false",
        "documentationProvider" to "source",
        "serializationLibrary" to "jackson"
    )
    )
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.2")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.postgresql:postgresql:42.6.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
    implementation("org.hibernate.validator:hibernate-validator:7.0.1.Final")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("io.getunleash:unleash-client-java:8.2.0")
}

configure<SourceSetContainer> {
    named("main") {
        java.srcDir("$buildDir/generated/src/main/")
        java.exclude("**/Application.kt")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

springBoot {
    mainClass.set("com.unleashdemo.backend.BackendApplicationKt")
}