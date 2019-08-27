package com.vuz.task.presentation.view

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.vuz.task.R

class AlertAuthErrorDialog(context: Context, val errorMessage: String?, themeResId: Int) :
    AlertDialog.Builder(context, themeResId) {

    @SuppressLint("InflateParams")
    @Override
    override fun create(): AlertDialog {
        setMessage(errorMessage)
        setCancelable(true)
        setPositiveButton(context.getString(R.string.ok), { dialogInterface, i -> dialogInterface.dismiss() })
        return super.create()
    }

}