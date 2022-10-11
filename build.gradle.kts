buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.7.10")
        classpath("com.rickclephas.kmp:kmp-nativecoroutines-gradle-plugin:0.12.6")
    }
}

plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("7.3.0").apply(false)
    id("com.android.library").version("7.3.0").apply(false)
    kotlin("android").version("1.7.10").apply(false)
    kotlin("multiplatform").version("1.7.10").apply(false)
//    id("com.rickclephas.kmp.nativecoroutines").version("0.13.0")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
