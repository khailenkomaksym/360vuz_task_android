package com.vuz.task.di.modules

import android.app.Application
import com.vuz.task.App
import com.vuz.task.data.executor.JobExecutor
import com.vuz.task.domain.executor.PostExecutionThread
import com.vuz.task.domain.executor.ThreadExecutor
import com.vuz.task.presentation.UIThread
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UIThread): PostExecutionThread

    @Binds
    abstract fun bindApplication(app: App): Application
}
