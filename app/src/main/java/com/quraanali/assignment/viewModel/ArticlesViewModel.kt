package com.quraanali.assignment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quraanali.assignment.model.models.Articles
import com.quraanali.assignment.model.repository.RepositoryManager
import com.quraanali.mvvm.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: RepositoryManager) : ViewModel() {

    private val articles = MutableLiveData<Resource<Articles>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchArticles()
    }

    private fun fetchArticles() {
        articles.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getArticles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ articlesList ->
                    articles.postValue(Resource.success(articlesList))
                }, {
                    articles.postValue(Resource.error("Something Went Wrong", null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getArticles(): LiveData<Resource<Articles>> {
        return articles
    }

}