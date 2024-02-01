package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import kotlin.concurrent.timer

class Stopwatch : AppCompatActivity() {
    private var time = 0; // 시간을 저장하는 변수
    private var timerTask: Timer? = null // 타이머 작업을 관리하는 변수
    private var isRunning = false // 스톱워치가 실행 중인지 나타내는 변수
    private var lap = 1 // 랩 타임을 카운트하는 변수

    lateinit var fab: FloatingActionButton // 시작/일시정지 버튼
    lateinit var secTextView1: TextView // 초를 표시하는 텍스트뷰
    lateinit var milliTextView : TextView // 밀리초를 표시하는 텍스트뷰
    lateinit var labLayout : LinearLayout // 랩 타임을 표시하는 레이아웃
    lateinit var labButton: Button  // 랩 타임을 기록하는 버튼
    lateinit var resetFab : FloatingActionButton // 리셋 버튼

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)

        var Homebutton : ImageButton = findViewById(R.id.home_button)

        Homebutton.setOnClickListener{
            val intent1 = Intent(this,Home::class.java)
            startActivity(intent1)
        }

        // 시작/일시정지 버튼 클릭 이벤트 처리
        fab = findViewById<FloatingActionButton>(R.id.fab)
        secTextView1 = findViewById<TextView>(R.id.secTextview)
        milliTextView = findViewById<TextView>(R.id.milliTextView2)
        labLayout = findViewById(R.id.labLayout)
        labButton = findViewById(R.id.labButton)
        resetFab = findViewById(R.id.resetFAB)

        fab.setOnClickListener {
            isRunning = !isRunning

            if (isRunning) {
                start()
            } else {
                pause()
            }
        }

        // 랩 타임 기록 버튼 클릭 이벤트 처리
        labButton.setOnClickListener{
            recordLapTime()
        }
        // 리셋 버튼 클릭 이벤트 처리
        resetFab.setOnClickListener{
            reset()
        }

    }

    private fun pause() {
        fab.setImageResource(R.drawable.baseline_play_arrow_24)
        timerTask?.cancel()
    }

    // 스톱워치 시작 함수
    private fun start() {
        fab.setImageResource(R.drawable.baseline_pause_24)

        timerTask = timer(period = 10) {
            time++
            val sec = time / 100
            val milli = time % 100
            runOnUiThread {
                secTextView1.text = "$sec"
                milliTextView.text = "$milli"
            }
        }
    }
    // 랩 타임 기록 함수
    private fun recordLapTime() {
        val laptime = this.time
        val textView = TextView(this)
        textView.text = "$lap LAB : ${laptime/100}.${laptime}"

        labLayout.addView(textView, 0)
        lap++
    }
    // 스톱워치 리셋 함수
    private fun reset(){
        timerTask?.cancel()
        time = 0
        isRunning = false
        fab.setImageResource(R.drawable.baseline_play_arrow_24)
        secTextView1.text = "0"
        milliTextView.text="00"

        labLayout.removeAllViews()
        lap = 1
    }
}


