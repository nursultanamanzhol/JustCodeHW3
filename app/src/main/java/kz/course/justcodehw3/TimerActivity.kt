package kz.course.justcodehw3

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TimerActivity : AppCompatActivity() {
    private lateinit var secondsText: TextView
    private lateinit var millisecondsText: TextView

    private lateinit var startButton: Button
//    private lateinit var backBtn: ImageView
    private lateinit var pauseButton: Button
    private lateinit var resetButton: Button

    private var countDownTimer: CountDownTimer? = null
    private var timeLeftInMillis: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)



        secondsText = findViewById(R.id.secondsText)
        millisecondsText = findViewById(R.id.millisecondsText)

        startButton = findViewById(R.id.startButton)
//        backBtn = findViewById(R.id.backBtn)
        pauseButton = findViewById(R.id.pauseButton)
        resetButton = findViewById(R.id.resetButton)

        val seconds = intent.getIntExtra("seconds", 0)
        timeLeftInMillis = (seconds * 1000).toLong()

        updateCountdownText()

//        backBtn.setOnClickListener {
//            onBackPressed()
//            finish()
//        }

        startButton.setOnClickListener {
            startTimer()
        }

        pauseButton.setOnClickListener {
            pauseTimer()
        }

        resetButton.setOnClickListener {
            resetTimer()
            onBackPressed()
            finish()
        }
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(timeLeftInMillis, 10) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateCountdownText()
            }

            override fun onFinish() {
                // Таймер закончился
                // Можете выполнить действия, если необходимо
            }
        }

        countDownTimer?.start()
    }

    private fun pauseTimer() {
        countDownTimer?.cancel()
    }

    private fun resetTimer() {
        countDownTimer?.cancel()
        timeLeftInMillis = 0
        updateCountdownText()
    }

    private fun updateCountdownText() {
        val minutes = (timeLeftInMillis / 60000).toInt()
        val seconds = (timeLeftInMillis % 60000 / 1000).toInt()
        val milliseconds = (timeLeftInMillis % 1000).toInt()

        secondsText.text = String.format("%02d", seconds)
        millisecondsText.text = String.format("%03d", milliseconds)
    }

}
