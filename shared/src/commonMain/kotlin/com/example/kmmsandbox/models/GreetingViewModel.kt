package com.example.kmmsandbox.models

import com.example.kmmsandbox.Greeting
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class GreetingViewModel: CommonViewModel() {
    val greetings = Greeting().greeting()

    fun observeGreetings(onChange: (List<String>) -> Unit) {
        greetings.onEach {
            onChange(it)
        }.launchIn(viewModelScope)
    }
}