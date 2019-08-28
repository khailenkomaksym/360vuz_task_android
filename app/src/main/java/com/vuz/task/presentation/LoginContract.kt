package com.vuz.task.presentation

import com.vuz.task.data.model.LoginResponse

interface LoginContract {
    interface View {

        fun onShowProgress()

        fun onHideProgress()

        fun onAuthError(errorMessage: String?)

        fun onDatabaseError(errorMessage: String?)

        fun onAuthSuccess(loginResponse: LoginResponse)

        fun onLoginInputSuccess()

        fun onLoginInputError(errorType: Int)

        fun onPasswordInputSuccess()

        fun onPasswordInputError(errorType: Int)

        fun onStartHome()

    }

    interface Presenter {

        fun attachView(view: View)

        fun detachView()

        fun signIn(login: String, password: String)

        fun checkLogin(login: String)

        fun checkPassword(password: String)

        fun handleSuccessAuth(loginResponse: LoginResponse)

    }
}