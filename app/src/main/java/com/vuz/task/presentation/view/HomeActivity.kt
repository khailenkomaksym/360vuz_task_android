package com.vuz.task.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vuz.task.R
import dagger.android.support.DaggerAppCompatActivity

class HomeActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

}