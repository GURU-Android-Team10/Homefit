package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Checklist : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checklist)
        var Homebutton : ImageButton = findViewById(R.id.home_button)

        Homebutton.setOnClickListener{
            val intent1 = Intent(this,Home::class.java)
            startActivity(intent1)}

    }
}