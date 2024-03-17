package com.example.orbitapplication.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainScreenViewModel: ViewModel() {

    private val _maxNumber = MutableLiveData<Int>()
    val maxNumber: LiveData<Int> get() = _maxNumber

    init {
        _maxNumber.value = 0
    }

    fun increaseNum(){
        _maxNumber.value = _maxNumber.value?.plus(1)
        Log.d("로그", _maxNumber.value.toString())
    }

    fun decreaseNum(){
        _maxNumber.value = _maxNumber.value?.minus(1)
    }
}