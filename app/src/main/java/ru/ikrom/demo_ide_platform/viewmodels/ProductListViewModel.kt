package ru.ikrom.demo_ide_platform.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(): ViewModel() {
    init {
        Log.d("ViewModel", "INIT")
    }
}