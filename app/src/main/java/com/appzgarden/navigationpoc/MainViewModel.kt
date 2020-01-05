package com.appzgarden.navigationpoc

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var schoolName= MutableLiveData<String>()
}