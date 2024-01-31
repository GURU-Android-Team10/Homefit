package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Stopwatch : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)

        var Homebutton : ImageButton = findViewById(R.id.home_button)

        Homebutton.setOnClickListener{
            val intent1 = Intent(this,Home::class.java)
            startActivity(intent1)}
    }
}