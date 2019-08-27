package com.vuz.task.di.modules
import com.vuz.task.presentation.ui.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityContributorModule {

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    /*@ContributesAndroidInjector(modules = [SingleUseCaseSampleActivityModule::class])
    abstract fun contributeSingleUseCaseActivity(): SingleUseCaseSampleActivity*/
}
