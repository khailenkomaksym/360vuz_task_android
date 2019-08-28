package com.vuz.task.di.component

import com.vuz.task.App
import com.vuz.task.di.modules.*
import com.vuz.task.domain.executor.PostExecutionThread
import com.vuz.task.domain.executor.ThreadExecutor
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityContributorModule::class, ApplicationModule::class,
                        NetworkModule::class, RoomModule::class])
interface ApplicationComponent : AndroidInjector<App> {

    fun threadExecutor(): ThreadExecutor

    fun postExecutionThread(): PostExecutionThread

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {

        abstract override fun build(): ApplicationComponent
    }
}