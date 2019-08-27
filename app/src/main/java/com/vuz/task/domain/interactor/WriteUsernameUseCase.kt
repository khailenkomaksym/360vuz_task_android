package com.vuz.task.domain.interactor

import com.vuz.task.domain.interactor.base.SynchronousUseCase
import com.vuz.task.domain.repostiory.LocalSharedPreferencesRepository
import javax.inject.Inject

class WriteUsernameUseCase
@Inject constructor(private val localPreferencesRepository: LocalSharedPreferencesRepository) :
    SynchronousUseCase<Unit, String> {

    override fun execute(params: String?) {
        localPreferencesRepository.writeUsername(params)
    }

}