package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.one.setOnClickListener {
            binding.inputBox.append("1")
        }
        binding.two.setOnClickListener {
            binding.inputBox.append("2")
        }
        binding.three.setOnClickListener {
            binding.inputBox.append("3")
        }
        binding.four.setOnClickListener {
            binding.inputBox.append("4")
        }
        binding.five.setOnClickListener {
            binding.inputBox.append("5")
        }
        binding.six.setOnClickListener {
            binding.inputBox.append("6")
        }
        binding.seven.setOnClickListener {
            binding.inputBox.append("7")
        }
        binding.eight.setOnClickListener {
            binding.inputBox.append("8")
        }
        binding.nine.setOnClickListener {
            binding.inputBox.append("9")
        }
        binding.zero.setOnClickListener {
            binding.inputBox.append("0")
        }
        binding.dot.setOnClickListener {
            binding.inputBox.append(".")
        }
        binding.plus.setOnClickListener {
            binding.inputBox.append("+")
        }
        binding.minus.setOnClickListener {
            binding.inputBox.append("-")
        }
        binding.multiply.setOnClickListener {
            binding.inputBox.append("*")
        }
        binding.divideButton.setOnClickListener {
            binding.inputBox.append("/")
        }
        binding.leftBracket.setOnClickListener {
            binding.inputBox.append("(")
        }
        binding.rightBracket.setOnClickListener {
            binding.inputBox.append(")")
        }

        binding.equalButton.setOnClickListener {
            onClickEqual()
        }
        binding.clearButton.setOnClickListener {
            binding.inputBox.text = ""
            binding.resultField.text = ""
        }
        binding.del.setOnClickListener {
            val text = binding.inputBox.text.toString()
            val newText = text.dropLast(1)
            binding.inputBox.text = newText
        }
    }


    @SuppressLint("SetTextI18n", "DefaultLocale")
    private fun onClickEqual() {
        val input = binding.inputBox.text.toString()
        if (input.isEmpty()) {
            Toast.makeText(this, "Input is empty", Toast.LENGTH_SHORT).show()
        } else {
            try {
                val expression = ExpressionBuilder(input).build()
                val result = expression.evaluate()
                if (result % 1 == 0.0) {
                    binding.resultField.text = String.format("%.0f", result)
                } else {
                    binding.resultField.text = String.format("%.3f", result)
                }


                binding.inputBox.text = ""
            } catch (e: Exception) {
                Toast.makeText(this, "Invalid Expression", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
