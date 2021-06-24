package com.example.ngncurrencyconverter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.ngncurrencyconverter.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var binding: ActivityMainBinding
    var selectedOption: String = "USD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spinner: Spinner = binding.currency
        ArrayAdapter.createFromResource(
            this,
            R.array.currency_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        spinner.setSelection(0)
        spinner.onItemSelectedListener = this
        binding.convert.setOnClickListener{ convertAmount()}
    }

    @SuppressLint("StringFormatInvalid")
    private fun convertAmount() {
        val stringInTextField = binding.enterAmount.text.toString()
        val exchangeRate: Int
        if (stringInTextField.isNotEmpty()) {
            exchangeRate = if(selectedOption == "USD") {
                500
            } else {
                // Change it to the exchange rate
                300
            }
            val cost = stringInTextField.toDouble()
            val total = cost/exchangeRate
            val formattedTotal = NumberFormat.getCurrencyInstance().format(total)
            binding.rate.text = getString(R.string.total, formattedTotal)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
       selectedOption = parent?.getItemAtPosition(position).toString()
    }
}


