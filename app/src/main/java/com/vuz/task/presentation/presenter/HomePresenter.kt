package com.vuz.task.presentation.presenter

import com.vuz.task.data.local.User
import com.vuz.task.domain.interactor.*
import com.vuz.task.presentation.HomeContract
import javax.inject.Inject

class HomePresenter
@Inject constructor(val signOutGithubUseCase: SignOutUseCase,
                    val readUserDatabaseUseCase: ReadUserDatabaseUseCase,
                    val readUsernameUseCase: ReadUsernameUseCase) : HomeContract.Presenter {

    var homeContractView: HomeContract.View? = null

    override fun attachView(view: HomeContract.View) {
        homeContractView = view
    }

    override fun detachView() {
        homeContractView = null
    }

    override fun getUserInfo() {
        val login = readUsernameUseCase.execute()
        readUserDatabaseUseCase.login = login
        readUserDatabaseUseCase.execute(observer = ExternalEventObserver())
    }

    override fun signOut() {
        signOutGithubUseCase.execute()
        homeContractView?.onStartLogin()
    }

    private inner class ExternalEventObserver : EmptyObserver<User>() {

        override fun onNext(t: User) {
            homeContractView?.onShowUserInfo(t)
        }

        override fun onError(e: Throwable) {
            homeContractView?.onError(e.message)
            super.onError(e)
        }
    }

}