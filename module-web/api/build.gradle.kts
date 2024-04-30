tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {

    implementation(project(":module-support:web"))
    implementation(project(":module-support:monitoring"))
    implementation(project(":module-support:logging"))
    implementation(project(":module-persistence:rdbms"))
    implementation(project(":module-persistence:nosql"))
    implementation(project(":module-core"))

    implementation("org.springframework.boot:spring-boot-starter-security")

    implementation("com.auth0:java-jwt:4.4.0")
    implementation("io.jsonwebtoken:jjwt-api:0.11.2")
    implementation("io.jsonwebtoken:jjwt-impl:0.11.2")
    implementation("io.jsonwebtoken:jjwt-jackson:0.11.2")

    // Only for test
    testCompileOnly("jakarta.servlet:jakarta.servlet-api")
    testCompileOnly("org.springframework.boot:spring-boot-starter-test")
    testApi("org.springframework.restdocs:spring-restdocs-mockmvc")
    testApi("org.springframework.restdocs:spring-restdocs-restassured")
    testApi("io.rest-assured:spring-mock-mvc")
}
