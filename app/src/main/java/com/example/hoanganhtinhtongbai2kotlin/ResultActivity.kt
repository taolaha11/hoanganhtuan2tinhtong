package com.example.hoanganhtinhtongbai2kotlin
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textViewResult: TextView = findViewById(R.id.textViewResult)

        val result = intent.getDoubleExtra("result", 0.0)

        textViewResult.text = "Result: $result"

        // Gửi kết quả về MainActivity và chuyển trang sau 2 giây
        setResult(RESULT_OK)
        val handler = android.os.Handler()
        handler.postDelayed({
            finish()
        }, 2000) // Chuyển trang sau 2 giây (có thể điều chỉnh thời gian theo nhu cầu)
    }
}

