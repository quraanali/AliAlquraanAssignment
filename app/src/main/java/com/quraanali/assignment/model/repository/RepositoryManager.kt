package com.quraanali.assignment.model.repository


import com.quraanali.assignment.model.models.Articles
import com.quraanali.assignment.model.repository.remote.ApiHelper
import io.reactivex.Single

class RepositoryManager(private val apiHelper: ApiHelper) {

    fun getArticles(): Single<Articles> {
        return apiHelper.getArticles()
    }

}