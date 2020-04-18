package com.uav.box.common.android.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST", "TooGenericExceptionCaught", "TooGenericExceptionThrown")
class GenericViewModelFactory<T : ViewModel> @Inject constructor(
        private val viewModelProvider: Provider<T>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        try {
            return viewModelProvider.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}