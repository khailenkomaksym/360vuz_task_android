package com.vuz.task.di.modules
import com.vuz.task.presentation.view.HomeActivity
import com.vuz.task.presentation.view.LoginGithubActivity
import com.vuz.task.presentation.view.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityContributorModule {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [LoginGithubActivityModule::class])
    abstract fun contributeLoginActivity(): LoginGithubActivity

    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun contributeHomeActivity(): HomeActivity
}
