@file:Suppress("LocalVariableName")

package com.nhatle.base_kotlin.TextView

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nhatle.base_kotlin.R

class LearnTextView : AppCompatActivity(), View.OnClickListener {
   private lateinit var text_msg:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.learn_text_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        text_msg = findViewById(R.id.txt_msg)
        val text_msg2:TextView = findViewById(R.id.txt_msg2)
//        text_msg.setOnClickListener { view ->
//            val goodbyeMsg = getString(R.string.text_goodbye)
//            if(text_msg.text.toString().compareTo(goodbyeMsg)==0){
//                text_msg.text = getString(R.string.txt_msg)
//            }else{
//                text_msg.text = getString(R.string.text_goodbye)
//            }
//
//        }
        text_msg.setOnClickListener(this)
        text_msg2.setOnClickListener(this)

    }

    @SuppressLint("ResourceAsColor")
    override fun onClick(p0: View?) {
        val goodbyeMsg = getString(R.string.text_goodbye)
        if(p0?.id ==R.id.txt_msg) {
            val text_msg = p0 as TextView
            if (text_msg.text.toString().compareTo(goodbyeMsg) == 0) {
                text_msg.text = getString(R.string.txt_msg)
            } else {
                text_msg.text = getString(R.string.text_goodbye)
            }
        }
        if(p0?.id ==R.id.txt_msg2) {
            val text_msg = p0 as TextView
            if (text_msg.text.toString().compareTo(goodbyeMsg) == 0) {
                text_msg.text = getString(R.string.txt_msg)
            } else {
                text_msg.text = getString(R.string.text_goodbye)
                text_msg.setTextColor(R.color.black)
            }
        }
    }
}