package com.example.kmmsandbox

import kotlinx.coroutines.delay
import kotlinx.datetime.*

fun daysUntilNewYear(): Int {
    val today = Clock.System.todayAt(TimeZone.currentSystemDefault())
    val closestNewYear = LocalDate(today.year + 1, 1, 1)
    return today.daysUntil(closestNewYear)
}

suspend fun daysPhrase(): String {
    delay(1000)
    return "There are only ${daysUntilNewYear()} days left until New Year! 🎅🏼"
}