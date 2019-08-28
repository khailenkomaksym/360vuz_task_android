package com.vuz.task.presentation.view

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.vuz.task.R
import com.vuz.task.domain.LoginErrors
import com.vuz.task.domain.PasswordErrors
import com.vuz.task.presentation.LoginContract
import com.vuz.task.presentation.presenter.LoginPresenter
import com.vuz.task.presentation.util.InternetUtil
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class LoginGithubActivity : DaggerAppCompatActivity(), LoginContract.View {

    @Inject
    lateinit var loginPresenter: LoginPresenter

    lateinit var textInputLayoutLogin: TextInputLayout
    lateinit var textInputEditTextLogin: TextInputEditText
    lateinit var textInputLayoutPassword: TextInputLayout
    lateinit var textInputEditTextPassword: TextInputEditText
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.title = getString(R.string.login_title)

        loginPresenter.attachView(this)

        textInputLayoutLogin = findViewById(R.id.textInputLayoutLogin)
        textInputEditTextLogin = findViewById(R.id.textInputEditTextLogin)
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword)
        textInputEditTextPassword = findViewById(R.id.textInputEditTextPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            loginPresenter.checkLogin(getLogin())

            hideKeyboard()
        }
    }

    private fun getLogin(): String {
        return textInputEditTextLogin.text.toString()
    }

    private fun getPassword(): String {
        return textInputEditTextPassword.text.toString()
    }

    private fun showErrorPopup(errorMessage: String?) {
        val alertDialog = AlertAuthErrorDialog(this, errorMessage, 0)
        alertDialog.show()
    }

    private fun hideKeyboard() {
        val view = this.currentFocus
        view?.let { v ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(v.windowToken, 0)
        }
    }

    override fun onShowProgress() {
    }

    override fun onHideProgress() {
    }

    override fun onAuthError(errorMessage: String?) {
        var error = errorMessage
        if (!InternetUtil.isNetworkAvailable(this)) {
            error = getString(R.string.internet_connection_error)
        }
        showErrorPopup(error)
    }

    override fun onAuthSuccess() {
    }

    override fun onLoginSuccess() {
        textInputLayoutLogin.error = null

        loginPresenter.checkPassword(getPassword())
    }

    override fun onLoginError(errorType: Int) {
        var errorMessage = ""

        if (errorType == LoginErrors.ERROR_EMPTY_FIELD) {
            errorMessage = getString(R.string.login_error_empty)
        } else if (errorType == LoginErrors.ERROR_NEED_ONLY_NUMBERS_CHARACTERS) {
            errorMessage = getString(R.string.login_error_need_only_alphanumeric)
        }

        textInputLayoutLogin.error = errorMessage
    }

    override fun onPasswordSuccess() {
        textInputLayoutPassword.error = null

        loginPresenter.signIn(getLogin(), getPassword())
    }

    override fun onPasswordError(errorType: Int) {
        var errorMessage = ""

        if (errorType == PasswordErrors.ERROR_EMPTY_FIELD) {
            errorMessage = getString(R.string.password_error_empty)
        } else if (errorType == PasswordErrors.ERROR_MIN_LENGTH) {
            errorMessage = getString(R.string.password_error_min_length)
        } else if (errorType == PasswordErrors.ERROR_NEED_TO_CHARACTERS) {
            errorMessage = getString(R.string.password_error_need_characters)
        }

        textInputLayoutPassword.error = errorMessage
    }
}
