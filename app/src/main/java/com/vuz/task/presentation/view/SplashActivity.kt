package com.vuz.task.presentation.view

import android.content.Intent
import android.os.Bundle
import com.vuz.task.R
import com.vuz.task.presentation.base.BaseActivity
import com.vuz.task.presentation.presenter.SplashPresenter
import com.vuz.task.presentation.SplashContract
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashContract.View {

    @Inject
    lateinit var splashPresenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashPresenter.attachView(this)
        splashPresenter.checkUser()
    }

    override fun onDestroy() {
        super.onDestroy()
        splashPresenter.detachView()
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