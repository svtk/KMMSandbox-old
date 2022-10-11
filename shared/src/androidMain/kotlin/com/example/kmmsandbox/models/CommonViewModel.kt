package com.example.kmmsandbox.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope as androidViewModelScope
import kotlinx.coroutines.CoroutineScope

actual abstract class CommonViewModel actual constructor() : ViewModel() {
    actual val viewModelScope: CoroutineScope = androidViewModelScope

    actual override fun onCleared() {
        super.onCleared()
    }
}