package kiu.dev.my_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import kiu.dev.my_calculator.data.AppVersion
import kiu.dev.my_calculator.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutId: Int = R.layout.activity_main

    private val versionData by lazy {
        AppVersion("1.0.0")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // Splash init
        installSplashScreen()
        super.onCreate(savedInstanceState)

        binding.activity = this
        binding.version = versionData.copy()

        binding.btnClick.setOnClickListener {
            Log.d("TestLog", "MainActivity btnClick setOnClickListener")
        }

        setStatusBarTransparent()
        defaultPadding(binding.clContainer)

    }

    fun onClickEvents(v: View) {
        when(v.id) {
            R.id.btn_click -> {
                Log.d("TestLog", "MainActivity btn_click onClickEvents")
            }
        }
    }


}