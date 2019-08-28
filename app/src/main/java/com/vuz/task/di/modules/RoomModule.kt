package com.vuz.task.di.modules

import android.app.Application
import android.content.Context
import com.vuz.task.App
import com.vuz.task.data.local.UserDao
import com.vuz.task.data.local.UsersDatabase
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @Provides
    fun provideUserDataSource(application: Application): UserDao {
        val database = UsersDatabase.getInstance(application)
        return database.userDao()
    }

}