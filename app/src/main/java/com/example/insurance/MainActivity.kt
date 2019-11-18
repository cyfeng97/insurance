package com.example.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener,
    AdapterView.OnItemSelectedListener {

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this, "Position " + position,
            Toast.LENGTH_LONG).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerAge.onItemSelectedListener = this
        buttonCalculate.setOnClickListener {
            calculatePremium()
        }
    }

    private fun calculatePremium() {
        val position = spinnerAge.selectedItemPosition
        val gender = radioGroupGender.checkedRadioButtonId
        var basic_premium: Int = 0
        val symbol = Currency.getInstance(Locale.getDefault()).symbol

        basic_premium = when(position){
            0 -> 60 //less than 17
            1 -> 70 //17 to 25
            2 -> 90 //26-30
            3 -> 12 //31-40
            else -> 150 // 41-55/more than 55
        }

        if (gender == R.id.radioButtonMale) {
            // TODO clculate premium for male
            basic_premium += when(position){
                0 -> 0
                1 -> 50
                2 -> 100
                3 -> 150
                else -> 200
            }

        }

        if (checkBoxYes.isChecked){
            // TODO calculate premium for smoker
            basic_premium += when(position){
                0 -> 0
                1 -> 100
                2 -> 150
                3 -> 200
                4 -> 250
                else -> 300
            }
        }
        textViewPremium.text = String.format("%s : %s %d",getString(R.string.insurance_premium),symbol,basic_premium)
    }

}
