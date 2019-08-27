package com.vuz.task.data.repository

import com.vuz.task.data.api.GithubAPI
import com.vuz.task.data.model.LoginResponse
import io.reactivex.Observable

class NetworkRepository(val githubAPI: GithubAPI) {

    fun login(auth: String): Observable<LoginResponse> {
        return githubAPI.login(auth)
    }

}