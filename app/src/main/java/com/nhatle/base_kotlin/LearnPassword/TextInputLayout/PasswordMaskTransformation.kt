package com.nhatle.base_kotlin.LearnPassword.TextInputLayout

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.google.android.material.textfield.TextInputLayout

class PasswordMaskTransformation private constructor() : PasswordTransformationMethod() {
    override fun getTransformation(source: CharSequence, view: View?): CharSequence {
        return PasswordCharSequence(source)
    }

    class PasswordCharSequence(private val source: CharSequence) : CharSequence {
        override val length: Int
            get() = source.length

        override fun get(index: Int): Char {
            return '*'
        }

        override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
            return source.subSequence(startIndex, endIndex)
        }
    }

    companion object {
        private val instance = PasswordMaskTransformation()

        fun getInstance(): PasswordMaskTransformation {
            return instance
        }
    }
}
fun TextInputLayout.addEndIconClickListener() {
    var isPasswordVisible = false
    this.setEndIconOnClickListener {
        if (isPasswordVisible) {
//            pass đã hiển thị
            isPasswordVisible = false
            editText?.transformationMethod = PasswordMaskTransformation.getInstance()
        } else {
//            pass chưa hiển thị
            isPasswordVisible = true
            editText?.transformationMethod = HideReturnsTransformationMethod()
        }
//        tao vị trí con trỏ chuoojt
        val length = editText?.text?.length
        editText?.setSelection(length ?: 0)
    }
}
