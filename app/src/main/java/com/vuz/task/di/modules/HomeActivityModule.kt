package com.vuz.task.di.modules

import com.vuz.task.data.repository.LocalSharedPreferencesRepositoryImpl
import com.vuz.task.data.repository.NetworkRepositoryImpl
import com.vuz.task.data.repository.UserRepositoryImpl
import com.vuz.task.domain.repostiory.LocalSharedPreferencesRepository
import com.vuz.task.domain.repostiory.NetworkRepository
import com.vuz.task.domain.repostiory.UserRepository
import com.vuz.task.presentation.HomeContract
import com.vuz.task.presentation.presenter.HomePresenter
import dagger.Binds
import dagger.Module

@Module
abstract class HomeActivityModule {

    @Binds
    abstract fun bindPresenter(presenter: HomePresenter): HomeContract.Presenter

    @Binds
    abstract fun bindUsersRepository(usersRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindLocalSharedPreferencesRepository(localSharedPreferencesRepositoryImpl: LocalSharedPreferencesRepositoryImpl): LocalSharedPreferencesRepository

}