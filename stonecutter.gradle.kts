plugins {
    id("dev.kikugie.stonecutter")
}

stonecutter active "1.21-fabric"

allprojects {
    repositories {
        mavenCentral()
        mavenLocal()
        maven("https://maven.neoforged.net/releases")
        maven("https://maven.fabricmc.net/")
        maven("https://maven.parchmentmc.org/")
    }
}