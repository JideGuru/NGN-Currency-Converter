package com.example.ngncurrencyconverter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.ngncurrencyconverter.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.convert.setOnClickListener{ convertAmount()}
    }

    @SuppressLint("StringFormatInvalid")
    private fun convertAmount() {
        val stringInTextField = binding.enterAmount.text.toString()
        val cost = stringInTextField.toDouble()
        val total = cost/500
        val formattedTotal = NumberFormat.getCurrencyInstance().format(total)
        binding.rate.text= getString(R.string.total, formattedTotal)


    }


}


