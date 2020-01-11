package com.example.navigationpoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigationpoc.java.JMainActivity
import com.example.navigationpoc.kotlin.KMainActivity

import kotlinx.android.synthetic.main.activity_choice.*

class ChoiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        btn_kotlin.setOnClickListener {
            startActivity(Intent(this, KMainActivity::class.java))
        }

        btn_java.setOnClickListener {
            startActivity(Intent(this, JMainActivity::class.java))
        }
    }
}
