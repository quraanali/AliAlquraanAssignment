package com.quraanali.assignment.model.repository.remote

class ApiHelper(private val apiService: ApiService) {

    fun getArticles() = apiService.getArticles()

}