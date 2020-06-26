package com.quraanali.assignment.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.quraanali.assignment.model.repository.RepositoryManager
import com.quraanali.assignment.model.repository.remote.ApiHelper
import com.quraanali.assignment.viewModel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                RepositoryManager(
                    apiHelper
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}