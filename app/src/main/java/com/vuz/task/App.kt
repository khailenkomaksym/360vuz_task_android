package com.vuz.task

import com.vuz.task.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out App> =
        DaggerApplicationComponent.builder().create(this)

    override fun onCreate() {
        super.onCreate()
    }

}