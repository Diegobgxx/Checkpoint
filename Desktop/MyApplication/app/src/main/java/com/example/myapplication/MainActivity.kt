package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my.xml)

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val radioButtonMale: RadioButton = findViewById(R.id.radioButtonMale)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)

        buttonCalculate.setOnClickListener {
            val heightString = editTextHeight.text.toString()
            if (heightString.isNotEmpty()) {
                val height = heightString.toFloat()
                val weight = if (radioButtonMale.isChecked) {
                    (72.7 * height) - 58
                } else {
                    (62.1 * height) - 44.7
                }
                val message = "Peso ideal: %.2f kg".format(weight)
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor, insira a altura", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
