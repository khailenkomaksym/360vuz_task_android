package com.vuz.task.domain.interactor

import com.vuz.task.data.local.User
import com.vuz.task.domain.interactor.base.SynchronousUseCase
import com.vuz.task.domain.repostiory.UserRepository
import javax.inject.Inject

class ReadUserDatabaseUseCase
@Inject constructor(private val userRepository: UserRepository) :
    SynchronousUseCase<User, String> {

    override fun execute(params: String?): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}