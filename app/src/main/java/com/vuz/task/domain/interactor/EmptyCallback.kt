package com.vuz.task.domain.interactor

import androidx.annotation.NonNull

interface EmptyCallback<T> {

    fun onSuccess() {}

    fun onError(@NonNull t: T) {}

}