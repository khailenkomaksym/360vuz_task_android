package com.vuz.task.presentation

interface SplashContract {
    interface View {

        fun onStartLogin()

        fun onStartHome()

    }

    interface Presenter {

        fun attachView(view: View)

        fun detachView()

        fun checkUser()

    }
}