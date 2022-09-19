package com.example.kmmsandbox

import kotlin.random.Random

class Greeting {
    private val platform: Platform = getPlatform()

    fun greeting(): List<String> = buildList {
        add(if (Random.nextBoolean()) "Hi!" else "Hello!")
        add("Guess what it is! > ${platform.name.reversed()}!")
    }
}
