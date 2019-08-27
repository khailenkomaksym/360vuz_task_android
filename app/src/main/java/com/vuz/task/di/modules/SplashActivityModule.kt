package com.vuz.task.di.modules

import com.vuz.task.data.repository.LocalSharedPreferencesRepositoryImpl
import com.vuz.task.domain.repostiory.LocalSharedPreferencesRepository
import com.vuz.task.presentation.presenter.SplashPresenter
import com.vuz.task.presentation.SplashContract
import dagger.Binds
import dagger.Module

@Module
abstract class SplashActivityModule {

    @Binds
    abstract fun bindPresenter(presenter: SplashPresenter): SplashContract.Presenter

    @Binds
    abstract fun bindLocalSharedPreferencesRepository(localSharedPreferencesRepositoryImpl: LocalSharedPreferencesRepositoryImpl): LocalSharedPreferencesRepository

}