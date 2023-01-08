package kiu.dev.my_calculator.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @BindingAdapter("app:setVersion", "app:setStr", requireAll = false)
    @JvmStatic
    fun setTextView(view: TextView, version: String? = "", str: String? = "") {
        view.text = "version : $version , $str"
    }
}