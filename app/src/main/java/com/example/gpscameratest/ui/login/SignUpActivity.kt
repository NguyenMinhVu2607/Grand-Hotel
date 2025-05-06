package com.example.gpscameratest.ui.login

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gpscameratest.R
import com.example.gpscameratest.databinding.ActivitySignUpBinding
import com.moneytracker.moneymanager.moneywallet.activity.base.BaseActivity

class SignUpActivity : BaseActivity<ActivitySignUpBinding>() {
    override fun getViewBinding(): ActivitySignUpBinding {
        return ActivitySignUpBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}