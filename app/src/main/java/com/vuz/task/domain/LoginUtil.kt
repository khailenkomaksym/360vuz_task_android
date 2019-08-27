package com.vuz.task.domain

import java.util.regex.Pattern

class LoginUtil {

    companion object {

        val REGEX_LOGIN = "[a-zA-Z0-9]*"

        fun isLoginAlphaNumeric(login: String): Boolean {
           return Pattern.matches(REGEX_LOGIN, login)
        }
    }

}