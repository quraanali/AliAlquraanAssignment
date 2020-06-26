package com.quraanali.assignment.model.repository.remote

import com.quraanali.assignment.model.models.Articles
import io.reactivex.Single

interface ApiService {

    fun getArticles(): Single<Articles>

}