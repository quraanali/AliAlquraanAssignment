package com.quraanali.assignment.model.repository.remote

import com.quraanali.assignment.model.models.Articles
import retrofit2.Call
import retrofit2.http.GET


interface AssignmentAPI {
    @GET("/svc/mostpopular/v2/viewed/1.json")
    fun getArticles(): Call<Articles>

}


