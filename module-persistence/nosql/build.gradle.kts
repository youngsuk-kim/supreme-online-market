tasks.getByName("bootJar") {
    enabled = false
}

tasks.getByName("jar") {
    enabled = true
}

dependencies {
    implementation(project(":module-core"))
    implementation("io.lettuce:lettuce-core:6.3.2.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
}
