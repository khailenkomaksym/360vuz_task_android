package com.vuz.task.di.component

import com.vuz.task.App
import com.vuz.task.di.modules.*
import com.vuz.task.presentation.ui.LoginActivity
import com.vuz.task.presentation.ui.HomeActivity
import com.vuz.task.presentation.ui.SplashActivity
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityContributorModule::class, ApplicationModule::class,
                        NetworkModule::class])
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {

        abstract override fun build(): ApplicationComponent
    }
}