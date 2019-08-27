package com.vuz.task.di.modules
import com.vuz.task.presentation.view.LoginActivity
import com.vuz.task.presentation.view.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityContributorModule {

    /*@ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity*/

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    abstract fun contributeLoginActivity(): LoginActivity
}
