package com.vuz.task.presentation

import com.vuz.task.data.local.User

interface HomeContract {

    interface View {

        fun onError(error: String?)

        fun onShowUserInfo(user: User)

        fun onStartLogin()

    }

    interface Presenter {

        fun attachView(view: View)

        fun detachView()

        fun getUserInfo()

        fun signOut()

    }

}