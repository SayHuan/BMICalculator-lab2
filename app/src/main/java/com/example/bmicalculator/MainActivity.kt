package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalc.setOnClickListener(){
            calcBMI()
        }

        btnReset.setOnClickListener(){
            edit_height.text = null
            edit_weight.setText("");
        }
    }

    private fun calcBMI(){

        try {
            val weight: Double = edit_weight.text.toString().toDouble()
            val height: Double = edit_height.text.toString().toDouble()

            val bmi: Double = weight / (height * height)



            if (bmi < 18.5) {
                imageView.setImageResource(R.drawable.under)
                viewBMI.text = "%.2f(UNDER)".format((bmi))
            } else if (bmi > 18.5 && bmi < 24.9) {
                imageView.setImageResource(R.drawable.normal)
                viewBMI.text = "%.2f(NORMAL)".format((bmi))
            } else {
                imageView.setImageResource(R.drawable.over)
                viewBMI.text = "%.2f(OVER)".format((bmi))
            }

            //nnn.text = "bmi: %.2f (%s)".format(bmi, result)
        }catch (e:Exception) {
            val toast: Toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG)

            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show()
        }
    }
}
