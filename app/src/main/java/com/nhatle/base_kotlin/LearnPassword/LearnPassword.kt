package com.nhatle.base_kotlin.LearnPassword
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nhatle.base_kotlin.R


class LearnPassword : AppCompatActivity(), View.OnClickListener {
    private var i = 0;
    private lateinit var passwordMaskTransformation: PasswordMaskTransformation
    private lateinit var img_pass:ImageView
    private lateinit var txt_pass:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_learn_password)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        img_pass = findViewById(R.id.img_pass)
        txt_pass = findViewById(R.id.edit_password)
        passwordMaskTransformation = PasswordMaskTransformation()
        txt_pass.transformationMethod = passwordMaskTransformation
        img_pass.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        p0?.let {
//            Cach 1:
//            if(it.id ==R.id.img_pass){
//                if (i%2==0){
//                    img_pass.setImageResource(R.drawable.ic_eye_hidden)
//                    txt_pass.transformationMethod = PasswordMaskTransformation()
//                    txt_pass.transformationMethod =
//                        HideReturnsTransformationMethod.getInstance()
//                }else{
//                    img_pass.setImageResource(R.drawable.ic_eye_display)
//                    txt_pass.transformationMethod = PasswordMaskTransformation()
//                }
//                i++
//                println(i)
//            }
//            Cach 2:
            if (txt_pass.transformationMethod.equals(passwordMaskTransformation)) {
                txt_pass.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                img_pass.setImageResource(R.drawable.ic_eye_hidden)
            } else {
                txt_pass.transformationMethod = passwordMaskTransformation
                img_pass.setImageResource(R.drawable.ic_eye_display)
            }
        }
    }
}