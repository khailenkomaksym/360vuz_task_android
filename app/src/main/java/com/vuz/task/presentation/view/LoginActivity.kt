package com.vuz.task.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.vuz.task.App
import com.vuz.task.R
import com.vuz.task.data.model.LoginResponse
import com.vuz.task.data.repository.NetworkRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Credentials
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var networkRepository: NetworkRepository

    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val auth: String = Credentials.basic("khailenkomaksym", "6565012MaX")

        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            login()
        }
    }

    fun login() {
        val auth: String = Credentials.basic("khailenkomaksym", "6565012Ma")
        fun login(): Observable<LoginResponse> = networkRepository.login(auth)
        login()
            .skip(1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
            {
                Log.d("myLogs", "login result: " + it.toString())
            },
            {
                Log.d("myLogs", "login error: " + it.toString())
            })
    }
}
