package kiu.dev.my_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import kiu.dev.my_calculator.data.AppVersion
import kiu.dev.my_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val versionData by lazy {
        AppVersion("1.0.0")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this
        binding.version = versionData.copy()

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