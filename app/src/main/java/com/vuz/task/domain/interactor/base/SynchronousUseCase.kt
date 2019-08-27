package com.vuz.task.domain.interactor.base

interface SynchronousUseCase<out Results, in Params> {

    fun execute(params: Params? = null): Results

}
