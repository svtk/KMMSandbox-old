package com.example.kmmsandbox.models

import kotlinx.coroutines.CoroutineScope

expect abstract class CommonViewModel() {
    val viewModelScope: CoroutineScope
    protected open fun onCleared()
}