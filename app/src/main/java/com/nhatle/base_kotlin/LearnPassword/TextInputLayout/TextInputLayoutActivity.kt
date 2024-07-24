package com.nhatle.base_kotlin.LearnPassword.TextInputLayout

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout
import com.nhatle.base_kotlin.R

class TextInputLayoutActivity : AppCompatActivity() {
    private lateinit var editPassword:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_text_input_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        editPassword = findViewById(R.id.tv_pass)
        editPassword.transformationMethod = PasswordMaskTransformation.getInstance()
        val textInputLayoutPassword =
            findViewById<TextInputLayout>(R.id.textInputLayout)
        textInputLayoutPassword.addEndIconClickListener()

    }
}