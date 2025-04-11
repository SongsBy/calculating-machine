package com.example.practice1

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practice1.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding
    private var currentInput = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        title = "계산기1"


        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)



        var btnList = listOf<Button>(
            binding.btn1 ,binding.btn2 ,binding.btn3 ,
            binding.btn4 ,binding.btn5 ,binding.btn6 ,
            binding.btn7 ,binding.btn8 ,binding.btn9 ,
            binding.btn10)

        for (button in btnList){
            button.setOnClickListener{
                currentInput += button.text
                binding.textView3.text = currentInput
            }
        }

        var optionbtn = listOf<Button>(
            binding.perent , binding.multi , binding.mienus, binding.plus)

        for (opt in optionbtn){
            opt.setOnClickListener {
                currentInput +=opt.text
                binding.textView3.text = currentInput
            }
        }

        binding.btnEqual .setOnClickListener {
            val res = add(currentInput)
            binding.textView3.text = res
            currentInput = ""

        }

        binding.textView3.text = "테스트" // onCreate 맨 아래에 임시로 넣어보세요

    }
}
private fun add (ex : String): String {

        val clean = ex.replace(" ", "")

        val oper = clean.find { it == '+' || it == '-' || it == '*' || it == '/' }

        if(oper == null) return "error"

        val parts = clean.split(oper)
        val num1 = parts[0].toDouble()
        val num2 = parts[1].toDouble()

        var result = when (oper) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> num1 / num2
            else -> 0.0
        }

        return result.toString()
    }
