package com.example.gpscameratest.ui.setting

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gpscameratest.R
import com.example.gpscameratest.databinding.ActivitySettingBinding
import com.moneytracker.moneymanager.moneywallet.activity.base.BaseActivity

class SettingActivity : BaseActivity<ActivitySettingBinding>() {
    override fun getViewBinding(): ActivitySettingBinding {
        return ActivitySettingBinding.inflate(layoutInflater)
    }

    override fun setupViews() {
        super.setupViews()
    }

    override fun setupListeners() {
        super.setupListeners()
    }

}