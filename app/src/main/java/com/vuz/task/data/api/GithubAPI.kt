package com.vuz.task.data.api

import com.vuz.task.data.model.LoginResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header

interface GithubAPI {

    @GET("user")
    fun login(@Header("Authorization") auth: String): Observable<LoginResponse>

}