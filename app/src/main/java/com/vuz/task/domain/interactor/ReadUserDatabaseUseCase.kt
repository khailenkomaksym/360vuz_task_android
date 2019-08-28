package com.vuz.task.domain.interactor

import com.vuz.task.data.local.User
import com.vuz.task.data.model.LoginResponse
import com.vuz.task.domain.executor.PostExecutionThread
import com.vuz.task.domain.executor.ThreadExecutor
import com.vuz.task.domain.interactor.base.ObservableUseCase
import com.vuz.task.domain.interactor.base.SynchronousUseCase
import com.vuz.task.domain.repostiory.NetworkRepository
import com.vuz.task.domain.repostiory.UserRepository
import io.reactivex.Observable
import javax.inject.Inject

class ReadUserDatabaseUseCase
@Inject
constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val userRepository: UserRepository
) : ObservableUseCase<User, Unit>(threadExecutor, postExecutionThread) {

    var login: String? = ""

    override fun buildUseCaseObservable(params: Unit?): Observable<User> {
        return userRepository.getInfoByLogin(login)
    }

}