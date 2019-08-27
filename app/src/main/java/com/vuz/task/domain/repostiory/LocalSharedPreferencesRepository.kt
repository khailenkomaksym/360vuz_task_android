package com.vuz.task.domain.repostiory

interface LocalSharedPreferencesRepository {

    fun signIn()

    fun signOut()

    fun isSignIn(): Boolean

    fun writeUsername(userName: String?)

    fun readUserName(): String?

}