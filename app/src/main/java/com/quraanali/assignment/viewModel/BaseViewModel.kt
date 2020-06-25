package com.quraanali.assignment.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
open class BaseViewModel(application: Application): AndroidViewModel(application) {

    val toast = MutableLiveData<String>()
    val toastRid = MutableLiveData<Int>()
    val showProgress = MutableLiveData<Boolean>()
}