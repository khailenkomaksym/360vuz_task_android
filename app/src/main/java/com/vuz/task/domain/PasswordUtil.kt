package com.vuz.task.domain

import java.util.regex.Pattern

class PasswordUtil {
    companion object {

        //todo uncomment
        //at least 1 char lower case, 1 char upper case, 1 number, 1 special character
        //val REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$&+,:;=\\\\?@#|/'<>.^*()%!-]).+$"

        //at least 1 char lower case, 1 char upper case, 1 number
        val REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).+$"

        fun isPasswordMatches(login: String): Boolean {
            return Pattern.matches(REGEX_PASSWORD, login)
        }

    }
}