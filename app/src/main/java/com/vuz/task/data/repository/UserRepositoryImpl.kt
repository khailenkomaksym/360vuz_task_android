package com.vuz.task.data.repository

import com.vuz.task.data.local.User
import com.vuz.task.data.local.UserDao
import com.vuz.task.domain.repostiory.UserRepository
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl
@Inject constructor(val userDao: UserDao): UserRepository {
    override fun getInfoByLogin(login: String): Observable<User> {
        return userDao.getInfoByLogin(login)
    }

    override fun insertUser(user: User?): Completable {
        return userDao.insertUser(user)
    }


}