import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val conversions = arrayOf(
        "Kilometers to Miles",
        "Miles to Kilometers",
        "Centimeters to Inches",
        "Inches to Centimeters",
        "Kilograms to Pounds",
        "Pounds to Kilograms"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, conversions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        convertButton.setOnClickListener { convert() }
    }

    private fun convert() {
        val input = inputEditText.text.toString()
        if (input.isNotEmpty()) {
            val inputValue = input.toDouble()
            val selectedConversion = spinner.selectedItemPosition
            val result = performConversion(inputValue, selectedConversion)
            outputTextView.text = result.toString()
        }
    }

    private fun performConversion(value: Double, conversion: Int): Double {
        return when (conversion) {
            0 -> kmToMiles(value)
            1 -> milesToKm(value)
            2 -> cmToInches(value)
            3 -> inchesToCm(value)
            4 -> kgToLb(value)
            5 -> lbToKg(value)
            else -> throw IllegalArgumentException("Invalid conversion")
        }
    }

    private fun kmToMiles(km: Double): Double {
        return km * 0.621371
    }

    private fun milesToKm(miles: Double): Double {
        return miles * 1.60934
    }

    private fun cmToInches(cm: Double): Double {
        return cm * 0.393701
    }

    private fun inchesToCm(inches: Double): Double {
        return inches * 2.54
    }

    private fun kgToLb(kg: Double): Double {
        return kg * 2.20462
    }

    private fun lbToKg(lb: Double): Double {
        return lb * 0.453592
    }
}
