package com.vuz.task.domain.interactor

import android.text.TextUtils
import com.vuz.task.domain.PasswordErrors
import com.vuz.task.domain.PasswordUtil
import com.vuz.task.domain.interactor.base.SynchronousUseCase
import javax.inject.Inject

class PasswordCheckUseCase
@Inject
constructor() : SynchronousUseCase<Unit, EmptyCallback<Int>> {

    var password: String = ""

    override fun execute(params: EmptyCallback<Int>?) {

        if (TextUtils.isEmpty(password)) {
            params?.onError(PasswordErrors.ERROR_EMPTY_FIELD)
        } else if (password.length < 8) {
            params?.onError(PasswordErrors.ERROR_MIN_LENGTH)
        } else if (!PasswordUtil.isPasswordMatches(password)) {
            params?.onError(PasswordErrors.ERROR_NEED_TO_CHARACTERS)
        } else {
            params?.onSuccess()
        }

    }


}