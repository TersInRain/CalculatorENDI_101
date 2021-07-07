package com.example.calculatorendi_101

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        button_0.setOnClickListener { textWindow("0") }
        button_1.setOnClickListener { textWindow("1") }
        button_2.setOnClickListener { textWindow("2") }
        button_3.setOnClickListener { textWindow("3") }
        button_4.setOnClickListener { textWindow("4") }
        button_5.setOnClickListener { textWindow("5") }
        button_6.setOnClickListener { textWindow("6") }
        button_7.setOnClickListener { textWindow("7") }
        button_8.setOnClickListener { textWindow("8") }
        button_9.setOnClickListener { textWindow("9") }
        button_dot.setOnClickListener { textWindow(".") }

        //Operations
        equal_button.setOnClickListener { textWindow("=") }
        button_plus.setOnClickListener { textWindow("+") }
        button_min.setOnClickListener { textWindow("-") }
        button_mult.setOnClickListener { textWindow("*") }
        button_divine.setOnClickListener { textWindow("/") }
        button_open.setOnClickListener { textWindow("(") }
        button_close.setOnClickListener { textWindow(")") }

        //ClearAll
          button_AC.setOnClickListener {
              dialog.text = ""
            result.text = ""
        }
        //Clears one mark
       button_Back.setOnClickListener {
            val back = dialog.text.toString()
            if (back.isNotEmpty()){
                dialog.text = back.substring(0, back.length-1)
                result.text = ""
            }
        }

        equal_button.setOnClickListener {
            try {
            val mathMain = ExpressionBuilder(dialog.text.toString()).build()
                val mathResult = mathMain.evaluate()
            val zxc =  mathResult.toLong()
            if (mathResult == zxc.toDouble())
                result.text = zxc.toString()
            else
                result.text = mathResult.toString()

            }catch (e:Exception) {
                Log.d("Error", "Message: ${e.message}")
            }
        }
    }

  fun textWindow(string: String) {

      if (result.text != "") {
          dialog.text =  result.text
          result.text = ""
      }
      dialog.append(string)
  }
}