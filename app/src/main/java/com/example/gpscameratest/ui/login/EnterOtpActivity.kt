package com.example.gpscameratest.ui.login

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gpscameratest.R
import com.example.gpscameratest.databinding.ActivityEnterOtpBinding
import com.moneytracker.moneymanager.moneywallet.activity.base.BaseActivity

class EnterOtpActivity : BaseActivity<ActivityEnterOtpBinding>() {
    override fun getViewBinding(): ActivityEnterOtpBinding {
        return ActivityEnterOtpBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}