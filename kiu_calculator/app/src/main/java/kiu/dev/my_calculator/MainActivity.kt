package kiu.dev.my_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import kiu.dev.my_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this

        binding.btnClick.setOnClickListener {
            Log.d("TestLog", "MainActivity btnClick setOnClickListener")
        }

    }

    fun onClickEvents(v: View) {
        when(v.id) {
            R.id.btn_click -> {
                Log.d("TestLog", "MainActivity btn_click onClickEvents")
            }
        }
    }
}