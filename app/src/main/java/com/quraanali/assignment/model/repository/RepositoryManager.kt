package com.quraanali.assignment.model.repositoryimport androidx.lifecycle.LiveDataimport com.quraanali.assignment.model.models.Articlesimport com.quraanali.assignment.util.MyEnumopen class RepositoryManager(private val source: Int) : RepositoryInterface {    private val localeRepository = LocalRepository()    private val remoteRepository = RemoteRepository()    override fun getArticles(): LiveData<Articles>? {        return if (source == MyEnum.REMOTE.value) {            remoteRepository.getArticles()        } else {            localeRepository.getArticles()        }    }}