package com.vuz.task.domain.interactor

import io.reactivex.observers.DisposableCompletableObserver

open class EmptyCompletableObserver : DisposableCompletableObserver() {

    override fun onComplete() {}

    override fun onError(e: Throwable) {}
}