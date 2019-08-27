package com.vuz.task.presentation.presenter

import com.vuz.task.domain.interactor.CheckUserSampleCase
import com.vuz.task.presentation.SplashContract
import javax.inject.Inject

class SplashPresenter
@Inject constructor(val checkUserSampleCase: CheckUserSampleCase) : SplashContract.Presenter {

    var splashContractView: SplashContract.View? = null

    override fun attachView(view: SplashContract.View) {
        splashContractView = view
    }

    override fun detachView() {
        splashContractView = null
    }

    override fun checkUser() {
        val isExists = checkUserSampleCase.execute()

        if (isExists) {
            splashContractView?.onStartHome()
        } else {
            splashContractView?.onStartLogin()
        }
    }
}