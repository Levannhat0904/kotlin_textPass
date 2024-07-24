@file:Suppress("LocalVariableName")

package com.nhatle.base_kotlin.EditText

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nhatle.base_kotlin.R

class LearnEditText : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_learn_edit_text)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btn_submit: Button = findViewById(R.id.btn_submit)

        btn_submit.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
//        if (p0?.id == R.id.btn_submit){
//            val edt_msg:EditText = findViewById(R.id.edt_msg)
//            val txt_result:TextView = findViewById(R.id.txt_result)
//            val msg = edt_msg.text
//            txt_result.text = msg
//            edt_msg.text.clear()
//        }
        p0?.let {
            if (it.id == R.id.btn_submit) {
                val edt_msg: EditText = findViewById(R.id.edt_msg)
                val txt_result: TextView = findViewById(R.id.txt_result)
                val msg = edt_msg.text
                txt_result.text = msg
                edt_msg.text.clear()
            }
        }
    }
}