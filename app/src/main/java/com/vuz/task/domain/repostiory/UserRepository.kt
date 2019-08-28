package com.vuz.task.domain.repostiory

import com.vuz.task.data.local.User
import io.reactivex.Completable
import io.reactivex.Observable

interface UserRepository {

    fun getInfoByLogin(login: String): Observable<User>

    fun insertUser(user: User?): Completable

}