package com.vuz.task.domain.interactor

import android.util.Log
import com.vuz.task.data.model.LoginResponse
import com.vuz.task.domain.executor.PostExecutionThread
import com.vuz.task.domain.executor.ThreadExecutor
import com.vuz.task.domain.interactor.base.ObservableUseCase
import com.vuz.task.domain.repostiory.NetworkRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class SignInGithubUseCase
@Inject
constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val networkRepository: NetworkRepository
) : ObservableUseCase<LoginResponse, Unit>(threadExecutor, postExecutionThread) {

    var userAuth: String = ""

    override fun buildUseCaseObservable(params: Unit?): Observable<LoginResponse> {
        return networkRepository.signIn(userAuth)
    }

}