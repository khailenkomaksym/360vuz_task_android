package com.vuz.task.presentation.presenter

import android.util.Log
import com.vuz.task.presentation.view.LoginView
import com.vuz.task.presentation.view.SplashView

class SplashPresenter {
    var splashView: SplashView? = null

    fun attachView(splashView: SplashView) {
        this.splashView = splashView
    }

    fun checkUser() {
        val isExists = false

        Log.d("myLogs", "presenter impl")

        if (isExists) {
            Log.d("myLogs", "presenter 1 impl: " + splashView)
            splashView?.onStartHome()
        } else {
            Log.d("myLogs", "presenter 2 impl")
            splashView?.onStartLogin()
        }
    }
}