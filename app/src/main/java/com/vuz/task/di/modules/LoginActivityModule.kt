package com.vuz.task.di.modules

import com.vuz.task.data.repository.LocalSharedPreferencesRepositoryImpl
import com.vuz.task.data.repository.NetworkRepositoryImpl
import com.vuz.task.domain.repostiory.LocalSharedPreferencesRepository
import com.vuz.task.domain.repostiory.NetworkRepository
import com.vuz.task.presentation.LoginContract
import com.vuz.task.presentation.presenter.LoginPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class LoginActivityModule {

    @Binds
    abstract fun bindPresenter(presenter: LoginPresenter): LoginContract.Presenter

    @Binds
    abstract fun bindNetworkRepository(networkRepositoryImpl: NetworkRepositoryImpl): NetworkRepository

    @Binds
    abstract fun bindLocalSharedPreferencesRepository(localSharedPreferencesRepositoryImpl: LocalSharedPreferencesRepositoryImpl): LocalSharedPreferencesRepository

}