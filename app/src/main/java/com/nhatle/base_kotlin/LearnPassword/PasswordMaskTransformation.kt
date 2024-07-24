package com.nhatle.base_kotlin.LearnPassword

import android.text.method.PasswordTransformationMethod
import android.view.View

/*
Ta có thể tạo mặt nạ mã hóa mật khẩu thay cho chấm tròn mặc định theo mong muốn của bản thân.
Để thực hiện điều này ta tạo lớp con kế thừa lớp PasswordTransformationMethod
Sau đó ghi đè phương thức getTransformation(CharSequence source, View view)
Sau đó ta tạo một lớp kế thừa lớp CharSequence, trong đó:
Ghi đè thuộc tính length để trả về chiều dài của các kí tự trong chuỗi đang xét.
Ghi đè phương thức get(index) để trả về kí tự mã hóa thay thế giá trị kí tự thực tế trong mật khẩu.
Ghi đè phương thức subSequence(start, end) để trả về chuỗi con trong đoạn start, end.
Ví dụ đoạn code sau tạo mặt nạ mã hóa mật khẩu cá nhân hóa sử dụng dấu * thay chấm tròn:
 */
class PasswordMaskTransformation : PasswordTransformationMethod() {
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
}
