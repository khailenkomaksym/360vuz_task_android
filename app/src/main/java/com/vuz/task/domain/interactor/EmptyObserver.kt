package com.vuz.task.domain.interactor

import io.reactivex.annotations.NonNull
import io.reactivex.observers.DisposableObserver

open class EmptyObserver<T> : DisposableObserver<T>() {

    override fun onNext(@NonNull t: T) {}

    override fun onError(@NonNull e: Throwable) {}

    override fun onComplete() {}

}