package com.vuz.task.domain.repostiory

import com.vuz.task.data.model.LoginResponse
import io.reactivex.Observable

interface NetworkRepository {

    fun signIn(auth: String): Observable<LoginResponse>

}