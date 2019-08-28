package com.vuz.task.domain.interactor

import com.vuz.task.data.local.User
import com.vuz.task.data.model.LoginResponse
import com.vuz.task.domain.executor.PostExecutionThread
import com.vuz.task.domain.executor.ThreadExecutor
import com.vuz.task.domain.interactor.base.CompletableUseCase
import com.vuz.task.domain.repostiory.UserRepository
import io.reactivex.Completable
import javax.inject.Inject

class WriteUserDatabaseUseCase
@Inject
constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val userRepository: UserRepository
) : CompletableUseCase<Unit>(threadExecutor, postExecutionThread) {

    var loginResponse: LoginResponse? = null

    override fun buildUseCaseCompletable(params: Unit?): Completable {

        val user = User(loginResponse?.id,
            loginResponse?.login,
            loginResponse?.avatarUrl,
            loginResponse?.type,
            loginResponse?.publicRepos
        )

        return userRepository.insertUser(user)
    }
}