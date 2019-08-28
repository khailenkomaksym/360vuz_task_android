package com.vuz.task.presentation.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.vuz.task.R
import com.vuz.task.data.local.User
import com.vuz.task.presentation.HomeContract
import com.vuz.task.presentation.presenter.HomePresenter
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity(), HomeContract.View {

    @Inject
    lateinit var homePresenter: HomePresenter

    lateinit var imageProfile: ImageView
    lateinit var btnLogout: Button
    lateinit var textId: TextView
    lateinit var textLogin: TextView
    lateinit var textType: TextView
    lateinit var textPublicRepos: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.title = getString(R.string.user_info_title)

        homePresenter.attachView(this)

        imageProfile = findViewById(R.id.imageProfile)
        btnLogout = findViewById(R.id.btnLogout)
        textId = findViewById(R.id.textId)
        textLogin = findViewById(R.id.textLogin)
        textType = findViewById(R.id.textType)
        textPublicRepos = findViewById(R.id.textPublicRepos)

        btnLogout.setOnClickListener {
            homePresenter.signOut()
        }

        homePresenter.getUserInfo()
    }

    override fun onError(error: String?) {
        val alertDialog = AlertAuthErrorDialog(this, error, 0)
        alertDialog.show()
    }

    override fun onShowUserInfo(user: User) {

        Glide.with(this).load(user.avatarUrl).into(imageProfile)
        textId.text = user.id.toString()
        textLogin.text = user.login
        textType.text = user.type
        textPublicRepos.text = user.public_repos.toString()

    }

    override fun onStartLogin() {
        startActivity(Intent(this, LoginGithubActivity::class.java))
        finish()
    }

    override fun onDestroy() {
        homePresenter.detachView()
        super.onDestroy()
    }

}