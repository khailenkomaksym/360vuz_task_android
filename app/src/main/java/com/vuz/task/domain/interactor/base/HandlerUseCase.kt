package com.vuz.task.domain.interactor.base

interface HandlerUseCase<in Params> {

    fun execute(params: Params? = null)

}
