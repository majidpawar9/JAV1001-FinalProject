package com.majid.cambrianapp.ui.apply

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ApplyViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Apply Fragment"
    }
    val text: LiveData<String> = _text
}