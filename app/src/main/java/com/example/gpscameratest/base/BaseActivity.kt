package com.moneytracker.moneymanager.moneywallet.activity.base

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.viewbinding.ViewBinding
import com.example.gpscameratest.R

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: VB
    protected abstract fun getViewBinding(): VB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        makeSystemBarsTransparent()
        hideSystemUI()
        setupViews()
        setupListeners()
    }

    /**
     * Ẩn status bar & navigation bar
     */
    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = ContextCompat.getColor(this, R.color.trans)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.setSystemBarsAppearance(
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    /**
     * Làm trong suốt thanh trạng thái và điều hướng (nếu muốn nền xuyên thấu)
     */
    private fun makeSystemBarsTransparent() {
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        window.navigationBarColor = android.graphics.Color.TRANSPARENT
    }

    /**
     * Hàm để setup UI trong activity con
     */
    protected open fun setupViews() {}

    /**
     * Hàm để setup click listener trong activity con
     */
    protected open fun setupListeners() {}

    /**
     * Tiện ích để gán nhiều onClick cùng lúc
     */
    protected fun setOnClickListeners(vararg views: View, onClick: (View) -> Unit) {
        views.forEach { it.setOnClickListener(onClick) }
    }
}
