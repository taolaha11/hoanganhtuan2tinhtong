package com.example.hoanganhtinhtongbai2kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var btnCalculate: Button

    private lateinit var calculateLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber1 = findViewById(R.id.editTextNumber1)
        editTextNumber2 = findViewById(R.id.editTextNumber2)
        btnCalculate = findViewById(R.id.btnCalculate)

        calculateLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                // Xử lý kết quả từ ResultActivity nếu cần
            }
        }

        btnCalculate.setOnClickListener {
            calculateAndOpenResultActivity()
        }
    }

    private fun calculateAndOpenResultActivity() {
        val strNumber1 = editTextNumber1.text.toString()
        val strNumber2 = editTextNumber2.text.toString()

        val number1 = strNumber1.toDoubleOrNull() ?: 0.0
        val number2 = strNumber2.toDoubleOrNull() ?: 0.0

        val result = number1 + number2

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("result", result)

        // Sử dụng launcher để mở ResultActivity và đợi kết quả
        calculateLauncher.launch(intent)
    }
}

