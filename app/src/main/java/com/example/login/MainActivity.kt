package com.example.login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // UI 요소 선언
    private lateinit var loginbtn: Button
    private lateinit var btnsignup : Button
    private lateinit var edituser: EditText
    private lateinit var editpword: EditText
    private lateinit var dbh: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI 요소 초기화
        loginbtn = findViewById(R.id.button4)
        btnsignup = findViewById(R.id.button5)
        edituser = findViewById(R.id.editTextTextPersonName2)
        editpword = findViewById(R.id.editTextTextPassword3)
        dbh = DBHelper(this)

        // 로그인 버튼에 대한 클릭 리스너 설정
        loginbtn.setOnClickListener {
            val useredtx = edituser.text.toString()
            val passedtx = editpword.text.toString()

            // 입력 필드 중 하나라도 비어 있는지 확인
            if(TextUtils.isEmpty(useredtx) || TextUtils.isEmpty(passedtx)){
                Toast.makeText(this, "아이디와 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else{
                // DBHelper를 사용하여 사용자 인증
                val checkuser = dbh.checkuserpass(useredtx, passedtx)
                if(checkuser==true){
                    Toast.makeText(this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, Home::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "아이디 혹은 비밀번호를 잘못 입력하셨습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
        // 회원가입 버튼에 대한 클릭 리스너 설정
        btnsignup.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
    }
}