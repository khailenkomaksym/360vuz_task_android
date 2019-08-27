package com.vuz.task.domain.interactor

import com.vuz.task.domain.interactor.base.SynchronousUseCase
import com.vuz.task.domain.repostiory.LocalSharedPreferencesRepository
import javax.inject.Inject

class SignOutUseCase
@Inject constructor(private val localPreferencesRepository: LocalSharedPreferencesRepository) : SynchronousUseCase<Unit, Unit> {

    override fun execute(params: Unit?) {
        localPreferencesRepository.signOut()
    }

}