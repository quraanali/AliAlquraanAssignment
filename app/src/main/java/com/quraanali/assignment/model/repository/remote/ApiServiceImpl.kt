package com.quraanali.assignment.model.repository.remote

import com.quraanali.assignment.model.models.Articles
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class ApiServiceImpl :
    ApiService {

    override fun getArticles(): Single<Articles> {
        return Rx2AndroidNetworking.get("http://api.nytimes.com/svc/mostpopular/v2/viewed/1.json?api-key=U1y7V7HbuuN2drfvKe78svV51fZl6FDx")
            .build()
            .getObjectSingle(Articles::class.java)
    }

}