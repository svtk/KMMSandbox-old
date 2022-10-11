package com.example.kmmsandbox.models

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

actual abstract class CommonViewModel {
    actual val viewModelScope = CoroutineScope(
        Dispatchers.Main + SupervisorJob()
    )

    protected actual open fun onCleared() {}

    fun clear() {
        viewModelScope.cancel()
        onCleared()
    }
}