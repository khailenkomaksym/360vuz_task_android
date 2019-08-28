package com.vuz.task.presentation.presenter

import android.util.Log
import androidx.annotation.NonNull
import com.vuz.task.data.model.LoginResponse
import com.vuz.task.domain.interactor.*
import com.vuz.task.presentation.LoginContract
import io.reactivex.observers.DisposableCompletableObserver
import okhttp3.Credentials
import javax.inject.Inject

class LoginPresenter
@Inject constructor(val signInGithubUseCase: SignInGithubUseCase,
                    val loginCheckUseCase: LoginCheckUseCase,
                    val passwordCheckUseCase: PasswordCheckUseCase,
                    val writeUsernameUseCase: WriteUsernameUseCase,
                    val writeUserDatabaseUseCase: WriteUserDatabaseUseCase,
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

    override fun handleSuccessAuth(loginResponse: LoginResponse) {
        writeUsernameUseCase.execute(loginResponse.login)
        signInUseCase.execute()
        writeUserDatabaseUseCase.loginResponse = loginResponse
        writeUserDatabaseUseCase.execute(observer = UploadObserver())
    }

    private inner class PasswordEventObserver : EmptyCallback<Int> {

        override fun onSuccess() {
            loginContractView?.onPasswordInputSuccess()
        }

        override fun onError(@NonNull t: Int) {
            loginContractView?.onPasswordInputError(t)
        }

    }

    private inner class LoginEventObserver : EmptyCallback<Int> {

        override fun onSuccess() {
            loginContractView?.onLoginInputSuccess()
        }

        override fun onError(@NonNull t: Int) {
            loginContractView?.onLoginInputError(t)
        }

    }

    private inner class ExternalEventObserver : EmptyObserver<LoginResponse>() {

        override fun onNext(t: LoginResponse) {
            loginContractView?.onAuthSuccess(t)
        }

        override fun onError(e: Throwable) {

            loginContractView?.onAuthError(e.message)
            super.onError(e)
        }
    }

    private inner class UploadObserver : DisposableCompletableObserver() {

        override fun onComplete() {
            loginContractView?.onStartHome()
        }

        override fun onError(e: Throwable) {
            loginContractView?.onDatabaseError(e.message)
        }
    }

}