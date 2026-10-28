// UniversalAdmin Placeholders - an official extension: PlaceholderAPI
// placeholders (%universaladmin_...%) for scoreboards, tab lists and chat
// formats. A separate plugin jar, built only against the public API
// (:universaladmin-api) like any third-party extension would be.

plugins {
    java
}

group = "dev.universaladmin.placeholders"
version = "1.6.1"
base.archivesName.set("universaladmin-placeholderapi")

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
    // Java 21 bytecode like every UniversalAdmin jar - see gradle.properties.
    disableAutoTargetJvm()
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") { name = "papermc" }
    // UniversalAdmin's releases - its jar contains the extension API.
    maven("https://api.modrinth.com/maven") { name = "modrinth" }
    maven("https://repo.extendedclip.com/releases/") { name = "placeholderapi" }
}

/** UniversalAdmin to compile against: a local build (-PuniversaladminJar=...) or the release from Modrinth. */
val universalAdmin: Any = providers.gradleProperty("universaladminJar").orNull?.let { files(it) }
    ?: "maven.modrinth:universaladmin:${property("universaladminVersion")}"

dependencies {
    compileOnly(universalAdmin)
    compileOnly("io.papermc.paper:paper-api:${property("paperApiVersion")}")
    compileOnly("me.clip:placeholderapi:2.11.6")

    testImplementation(platform("org.junit:junit-bom:5.12.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation(universalAdmin)
    testImplementation("io.papermc.paper:paper-api:${property("paperApiVersion")}")
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.release.set(21)
    options.compilerArgs.add("-parameters")
}

tasks.test {
    useJUnitPlatform()
}

tasks.processResources {
    val props = mapOf("version" to project.version)
    inputs.properties(props)
    filesMatching("plugin.yml") {
        expand(props)
    }
}

// Every jar carries its license (GPL-3.0-or-later).
tasks.withType<Jar>().configureEach {
    from("LICENSE") {
        into("META-INF")
    }
}

tasks.register("printVersion") {
    group = "help"
    description = "Prints the project version (used by the release workflow's tag check)."
    val projectVersion = project.version.toString()
    doLast { println(projectVersion) }
}
