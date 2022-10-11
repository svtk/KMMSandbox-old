package com.example.kmmsandbox

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.random.Random

class Greeting {
    private val platform: Platform = getPlatform()
    private val rocketComponent = RocketComponent()

    fun greeting(): Flow<List<String>> =
        channelFlow {
            send(if (Random.nextBoolean()) "Hi!" else "Hello!")
            send("Guess what it is! > ${platform.name.reversed()}!")
            launch {
                send(daysPhrase())
            }
            launch {
                send(rocketComponent.launchPhrase())
            }
        }.scan(listOf()) { list, value -> list + value }
}
