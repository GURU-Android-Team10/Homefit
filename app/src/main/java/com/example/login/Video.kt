package com.example.login

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Video : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        var button1: Button = findViewById(R.id.button_workout1)
        var button2: Button = findViewById(R.id.button_workout2)
        var Homebutton : Button = findViewById(R.id.homebutton)


        Homebutton.setOnClickListener{
            val intent1 = Intent(this,Home::class.java)
            startActivity(intent1)}
        // 버튼 클릭 이벤트 리스너 설정
        button1.setOnClickListener(View.OnClickListener {
            // 하이퍼링크로 이동하는 Intent 생성
            val intent2 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=fFTCnquxJbA"))
            // Intent 실행
            startActivity(intent2)
        })

        button2.setOnClickListener(View.OnClickListener {
            // 하이퍼링크로 이동하는 Intent 생성
            val intent3 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=7Vqv5SmSKHY"))
            // Intent 실행
            startActivity(intent3)
        })

    }
}