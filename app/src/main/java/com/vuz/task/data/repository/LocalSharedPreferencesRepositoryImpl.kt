package com.vuz.task.data.repository

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.vuz.task.domain.repostiory.LocalSharedPreferencesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalSharedPreferencesRepositoryImpl @Inject constructor(val application: Application) : LocalSharedPreferencesRepository {

    companion object {
        private const val USER_SIGN = "userSign"
        private const val USERNAME = "username"
    }

    private val sharedPreferences: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(
            application
        )
    }

    override fun isSignIn(): Boolean {
        return sharedPreferences.getBoolean(USER_SIGN, false)
    }

    override fun signOut() {
        sharedPreferences.edit()
            .putBoolean(USER_SIGN, false)
            .apply()
    }

    override fun signIn() {
        sharedPreferences.edit()
            .putBoolean(USER_SIGN, true)
            .apply()
    }

    override fun writeUsername(userName: String?) {
        sharedPreferences.edit()
            .putString(USERNAME, userName)
            .apply()
    }

    override fun readUserName(): String? {
        return sharedPreferences.getString(USERNAME, "")
    }
}