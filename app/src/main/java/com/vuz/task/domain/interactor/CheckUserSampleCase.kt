package com.vuz.task.domain.interactor

import com.vuz.task.domain.interactor.base.SynchronousUseCase
import com.vuz.task.domain.repostiory.LocalSharedPreferencesRepository
import javax.inject.Inject

class CheckUserSampleCase
@Inject constructor(private val localPreferencesRepository: LocalSharedPreferencesRepository) : SynchronousUseCase<Boolean, Unit> {

    override fun execute(params: Unit?): Boolean {
        return localPreferencesRepository.isSignIn()
    }

}