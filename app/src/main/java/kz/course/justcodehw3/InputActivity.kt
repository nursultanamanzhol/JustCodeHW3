package kz.course.justcodehw3


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class InputActivity : AppCompatActivity() {
    private lateinit var secondsInputLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        secondsInputLayout = findViewById(R.id.secondsEditText)

        val checkButton = findViewById<Button>(R.id.checkButton)
        val startTimerButton = findViewById<Button>(R.id.startTimerButton)

        checkButton.setOnClickListener {
            val secondsStr = secondsInputLayout.editText?.text.toString()
            if (secondsStr.isNotEmpty()) {
                val seconds = secondsStr.toInt()
                openTimerActivity(seconds)
            } else {
                secondsInputLayout.error = "Введите количество секунд"
            }
        }

        startTimerButton.setOnClickListener {
            val secondsStr = secondsInputLayout.editText?.text.toString()
            if (secondsStr.isNotEmpty()) {
                val seconds = secondsStr.toInt()
                openTimerActivity(seconds)
            } else {
                secondsInputLayout.error = "Введите количество секунд"
            }
        }
    }

    private fun openTimerActivity(seconds: Int) {
        val intent = Intent(this, TimerActivity::class.java)
        intent.putExtra("seconds", seconds)
        startActivity(intent)
    }
}
