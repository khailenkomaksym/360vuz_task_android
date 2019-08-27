package com.vuz.task.presentation.presenter

import android.util.Log
import androidx.annotation.NonNull
import com.vuz.task.data.model.LoginResponse
import com.vuz.task.domain.interactor.*
import com.vuz.task.presentation.LoginContract
import okhttp3.Credentials
import javax.inject.Inject

class LoginPresenter
@Inject constructor(val signInGithubUseCase: SignInGithubUseCase,
                    val loginCheckUseCase: LoginCheckUseCase,
                    val passwordCheckUseCase: PasswordCheckUseCase,
                    val writeUsernameUseCase: WriteUsernameUseCase,
                    val signInUseCase: SignInUseCase) : LoginContract.Presenter {

    var loginContractView: LoginContract.View? = null

    override fun attachView(view: LoginContract.View) {
        loginContractView = view
    }

    override fun detachView() {
        loginContractView = null
        signInGithubUseCase.dispose()
    }

    override fun checkLogin(login: String) {
        loginCheckUseCase.login = login
        loginCheckUseCase.execute(LoginEventObserver())
    }

    override fun checkPassword(password: String) {
        passwordCheckUseCase.password = password
        passwordCheckUseCase.execute(PasswordEventObserver())
    }

    override fun signIn(login: String, password: String) {
        loginContractView?.onShowProgress()

        signInGithubUseCase.userAuth = Credentials.basic(login, password)
        signInGithubUseCase.execute(observer = ExternalEventObserver())
    }

    private inner class PasswordEventObserver : EmptyCallback<Int> {

        override fun onSuccess() {
            loginContractView?.onPasswordSuccess()
        }

        override fun onError(@NonNull t: Int) {
            loginContractView?.onPasswordError(t)
        }

    }

    private inner class LoginEventObserver : EmptyCallback<Int> {

        override fun onSuccess() {
            loginContractView?.onLoginSuccess()
        }

        override fun onError(@NonNull t: Int) {
            loginContractView?.onLoginError(t)
        }

    }

    private inner class ExternalEventObserver : EmptyObserver<LoginResponse>() {

        override fun onNext(t: LoginResponse) {
            loginContractView?.onAuthSuccess()
        }

        override fun onError(e: Throwable) {

            loginContractView?.onAuthError(e.message)
            super.onError(e)
        }
    }

}