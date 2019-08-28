package com.vuz.task.domain.interactor.base

import com.vuz.task.domain.executor.PostExecutionThread
import com.vuz.task.domain.executor.ThreadExecutor
import com.vuz.task.domain.interactor.EmptyCompletableObserver
import io.reactivex.Completable
import io.reactivex.observers.DisposableCompletableObserver

abstract class CompletableUseCase<in Params>(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : BaseReactiveUseCase(threadExecutor, postExecutionThread) {

    abstract fun buildUseCaseCompletable(params: Params? = null): Completable

    fun execute(observer: DisposableCompletableObserver = EmptyCompletableObserver(), params: Params? = null) {
        val completable = buildUseCaseCompletableWithSchedulers(params)
        addDisposable(completable.subscribeWith(observer))
    }

    private fun buildUseCaseCompletableWithSchedulers(params: Params?): Completable {
        return buildUseCaseCompletable(params)
            .subscribeOn(threadExecutorScheduler)
            .observeOn(postExecutionThreadScheduler)
    }
}