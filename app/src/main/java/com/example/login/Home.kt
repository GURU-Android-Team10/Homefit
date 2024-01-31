package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Home : AppCompatActivity() {
    lateinit var Button1: Button
    lateinit var Button2: Button
    lateinit var Button3: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Button1 = findViewById<Button>(R.id.button1)
        Button2 = findViewById<Button>(R.id.button2)
        Button3 = findViewById<Button>(R.id.button3)

        Button1.setOnClickListener{
            val intent1 = Intent(this,Checklist::class.java)
            startActivity(intent1)}

        Button2.setOnClickListener{
            val intent2 = Intent(this, Stopwatch::class.java)
            startActivity(intent2)}

        Button3.setOnClickListener{
            val intent3 = Intent(this, Video::class.java)
            startActivity(intent3) }


    }
}