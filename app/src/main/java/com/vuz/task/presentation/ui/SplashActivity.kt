package com.vuz.task.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.vuz.task.App
import com.vuz.task.R
import com.vuz.task.data.repository.NetworkRepository
import com.vuz.task.presentation.base.BaseActivity
import com.vuz.task.presentation.presenter.LoginPresenter
import com.vuz.task.presentation.presenter.SplashPresenter
import com.vuz.task.presentation.view.LoginView
import com.vuz.task.presentation.view.SplashView
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashView {

    //@Inject
    //lateinit var splashPresenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //splashPresenter.attachView(this)

        //splashPresenter.checkUser()
    }

    override fun onStartHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    override fun onStartLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

}