package kiu.dev.my_calculator

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B: ViewDataBinding>: AppCompatActivity() {

    /**
     * view data binding
     */
    protected lateinit var binding: B
        private set

    /**
     * data binding layoutId
     */
    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutId)
    }

    /**
     * 상태바 숨김시 해당 높이값을 구해서 패딩 적용
     */
    open fun defaultPadding(container: ConstraintLayout) {
        container.setPadding(
            0,
            statusBarHeight(),
            0,
            navigationHeight()
        )
    }
}