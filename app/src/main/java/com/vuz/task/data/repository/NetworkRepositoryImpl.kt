package com.vuz.task.data.repository

import com.vuz.task.data.api.GithubAPI
import com.vuz.task.data.model.LoginResponse
import com.vuz.task.domain.repostiory.NetworkRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkRepositoryImpl
@Inject constructor(val githubAPI: GithubAPI) : NetworkRepository {

    override fun signIn(auth: String?): Observable<LoginResponse> {
        return githubAPI.login(auth)
    }

}