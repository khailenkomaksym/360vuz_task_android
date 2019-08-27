package com.vuz.task.domain.interactor

import com.vuz.task.domain.interactor.base.SynchronousUseCase
import com.vuz.task.domain.repostiory.LocalSharedPreferencesRepository
import javax.inject.Inject

class ReadUsernameUseCase
@Inject constructor(private val localPreferencesRepository: LocalSharedPreferencesRepository) :
    SynchronousUseCase<String?, Unit> {

    override fun execute(params: Unit?): String? {
        return localPreferencesRepository.readUserName()
    }

}