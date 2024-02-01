package com.example.login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.w3c.dom.Text

class signup : AppCompatActivity() {
    // UI 요소 선언
    private lateinit var uname: EditText
    private lateinit var pword: EditText
    private lateinit var cpword: EditText
    private lateinit var signupbtn: Button

    //DBHelper 인스턴스
    private lateinit var db: DBHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // UI 요소 및 DBHelper 초기화
        uname = findViewById(R.id.editTextTextPersonName)
        pword = findViewById(R.id.editTextTextPassword)
        cpword = findViewById(R.id.editTextTextPassword2)
        signupbtn = findViewById(R.id.button3)
        db = DBHelper(this)

        // 회원가입 버튼에 대한 클릭 리스너 설정
        signupbtn.setOnClickListener {
            val unametext = uname.text.toString()
            val pwordtext = pword.text.toString()
            val cpwordtext = cpword.text.toString()
            val savedata = db.insertdata(unametext, pwordtext) // DBHelper의 insertdata 메서드를 호출하여 사용자 데이터 저장

            // 입력 필드 중 하나라도 비어 있는지 확인
            if(TextUtils.isEmpty(unametext) || TextUtils.isEmpty(pwordtext) || TextUtils.isEmpty(cpwordtext)){
                Toast.makeText(this, "아이디와 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else{
                // 비밀번호가 일치하는지 확인
                if(pwordtext.equals(cpwordtext)){
                    // 데이터 삽입이 성공했는지 확인
                    if(savedata==true){
                        Toast.makeText(this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this, "이미 존재하는 아이디입니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(this, "비밀번호가 맞지 않습니다. 다시 입력해주세요.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}