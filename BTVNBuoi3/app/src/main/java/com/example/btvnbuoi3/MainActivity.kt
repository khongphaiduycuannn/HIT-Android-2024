package com.example.btvnbuoi3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val tvInput: TextView by lazy { findViewById(R.id.tvInput) }
    private val tvResult: TextView by lazy { findViewById(R.id.tvResult) }

    private val btnAdd: Button by lazy { findViewById(R.id.btnAdd) }
    private val btnSub: Button by lazy { findViewById(R.id.btnSub) }
    private val btnMul: Button by lazy { findViewById(R.id.btnMul) }
    private val btnDiv: Button by lazy { findViewById(R.id.btnDiv) }
    private val btnCal: Button by lazy { findViewById(R.id.btnCal) }

    private val btnDelete: ImageButton by lazy { findViewById(R.id.btnDelete) }
    private val btnClear: Button by lazy { findViewById(R.id.btnClear) }

    private val btnOne: Button by lazy { findViewById(R.id.btnOne) }
    private val btnTwo: Button by lazy { findViewById(R.id.btnTwo) }
    private val btnThree: Button by lazy { findViewById(R.id.btnThree) }
    private val btnFour: Button by lazy { findViewById(R.id.btnFour) }
    private val btnFive: Button by lazy { findViewById(R.id.bntFive) }
    private val btnSix: Button by lazy { findViewById(R.id.bntSix) }
    private val btnSeven: Button by lazy { findViewById(R.id.btnSeven) }
    private val btnEight: Button by lazy { findViewById(R.id.btnEight) }
    private val btnNine: Button by lazy { findViewById(R.id.btnNine) }
    private val btnZero: Button by lazy { findViewById(R.id.btnZero) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnZero.setOnClickListener(onNumberButtonClick)
        btnOne.setOnClickListener(onNumberButtonClick)
        btnTwo.setOnClickListener(onNumberButtonClick)
        btnThree.setOnClickListener(onNumberButtonClick)
        btnFour.setOnClickListener(onNumberButtonClick)
        btnFive.setOnClickListener(onNumberButtonClick)
        btnSix.setOnClickListener(onNumberButtonClick)
        btnSeven.setOnClickListener(onNumberButtonClick)
        btnEight.setOnClickListener(onNumberButtonClick)
        btnNine.setOnClickListener(onNumberButtonClick)

        btnAdd.setOnClickListener(onOperatorButtonClick)
        btnSub.setOnClickListener(onOperatorButtonClick)
        btnMul.setOnClickListener(onOperatorButtonClick)
        btnDiv.setOnClickListener(onOperatorButtonClick)

        btnCal.setOnClickListener {
            if (calculate() != null)
                tvResult.text = "${calculate()}"
        }

        btnClear.setOnClickListener {
            clear()
        }

        btnDelete.setOnClickListener {
            if (!tvInput.text.isNullOrEmpty()) {
                tvInput.text = tvInput.text.toString().dropLast(1)
            }
        }
    }

    private val onNumberButtonClick = View.OnClickListener { view ->
        val input = tvInput.text.toString()
        when (view.id) {
            btnZero.id -> tvInput.text = "${input}0"
            btnOne.id -> tvInput.text = "${input}1"
            btnTwo.id -> tvInput.text = "${input}2"
            btnThree.id -> tvInput.text = "${input}3"
            btnFour.id -> tvInput.text = "${input}4"
            btnFive.id -> tvInput.text = "${input}5"
            btnSix.id -> tvInput.text = "${input}6"
            btnSeven.id -> tvInput.text = "${input}7"
            btnEight.id -> tvInput.text = "${input}8"
            btnNine.id -> tvInput.text = "${input}9"
        }
    }

    private val onOperatorButtonClick = View.OnClickListener { view ->
        val input = tvInput.text.toString()
        if (input.isNotEmpty() && !containOperator(input)) {
            when (view.id) {
                btnAdd.id -> tvInput.text = "${input}+"
                btnSub.id -> tvInput.text = "${input}-"
                btnMul.id -> tvInput.text = "${input}x"
                btnDiv.id -> tvInput.text = "${input}/"
            }
        }
    }

    private fun containOperator(input: String): Boolean {
        return input.contains("[+\\-x/]".toRegex())
    }

    private fun calculate(): Double? {
        try {
            val input = tvInput.text
            val firstNum = input.split("[+\\-x/]".toRegex())[0].toDouble()
            val secondNum = input.split("[+\\-x/]".toRegex())[1].toDouble()
            val operator = input.split("[0-9.]".toRegex()).filter { it.isNotEmpty() }[0]

            return when (operator) {
                "+" -> firstNum + secondNum
                "-" -> firstNum - secondNum
                "x" -> firstNum * secondNum
                "/" -> firstNum / secondNum
                else -> null
            }
        } catch (_: Exception) {
            return null
        }
    }

    private fun clear() {
        tvInput.text = null
        tvResult.text = null
    }
}