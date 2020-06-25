package com.quraanali.assignment.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import com.quraanali.assignment.model.models.Articles
import com.quraanali.assignment.model.repository.RepositoryManager
import com.quraanali.assignment.util.MyEnum


class ArticlesViewModel(
    ctx: Application
) : BaseViewModel(ctx) {

//    val articles: LiveData<MutableList<Articles>> = liveData {
//        val result = categoryRepository.getCategories()
//        when (result) {
//            is RepoSuccessResponse -> {
//                emit(result.body.data)
//            }
//
//            is RepoEmptyResponse -> {
//            }
//
//            is RepoErrorResponse -> {
//                toast.postValue(result.errorMessage)
//            }
//        }
//    }


    private var mResponse: LiveData<Articles>? = null
    private var mRepository = RepositoryManager(MyEnum.REMOTE.value)

    fun getArticles(): LiveData<Articles> {
        mResponse = mRepository.getArticles()

        return mResponse!!
    }


}