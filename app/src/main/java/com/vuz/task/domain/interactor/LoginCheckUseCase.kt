package com.vuz.task.domain.interactor

import android.text.TextUtils
import com.vuz.task.domain.LoginErrors
import com.vuz.task.domain.LoginUtil
import com.vuz.task.domain.PasswordErrors
import com.vuz.task.domain.interactor.base.SynchronousUseCase
import javax.inject.Inject

class LoginCheckUseCase
@Inject
constructor() : SynchronousUseCase<Unit, EmptyCallback<Int>> {

    var login: String = ""

    override fun execute(params: EmptyCallback<Int>?) {

        if (TextUtils.isEmpty(login)) {
            params?.onError(LoginErrors.ERROR_EMPTY_FIELD)
        } else if (!LoginUtil.isLoginAlphaNumeric(login)) {
            params?.onError(LoginErrors.ERROR_NEED_ONLY_NUMBERS_CHARACTERS)
        } else {
            params?.onSuccess()
        }

    }


}