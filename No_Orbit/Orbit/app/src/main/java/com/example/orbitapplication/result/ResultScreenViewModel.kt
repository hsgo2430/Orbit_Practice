package com.example.orbitapplication.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.max
import kotlin.random.Random

class ResultScreenViewModel(): ViewModel() {

    private val _randomNumber = MutableLiveData<Int>()
    val randomNumber: LiveData<Int> get() = _randomNumber

    init {
        _randomNumber.value = 0
    }
    fun makeRandomNumber(maxNumber: Int){
        _randomNumber.value = Random.nextInt(0, maxNumber)
    }
}