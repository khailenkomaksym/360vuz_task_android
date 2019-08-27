package com.vuz.task.presentation

interface LoginContract {
    interface View {

        fun onShowProgress()

        fun onHideProgress()

        fun onAuthError(errorMessage: String?)

        fun onAuthSuccess()

        fun onLoginSuccess()

        fun onLoginError(errorType: Int)

        fun onPasswordSuccess()

        fun onPasswordError(errorType: Int)

    }

    interface Presenter {

        fun attachView(view: View)

        fun detachView()

        fun signIn(login: String, password: String)

        fun checkLogin(login: String)

        fun checkPassword(password: String)

    }
}