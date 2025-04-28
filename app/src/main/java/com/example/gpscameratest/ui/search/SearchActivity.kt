package com.example.gpscameratest.ui.search

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gpscameratest.R
import com.example.gpscameratest.databinding.ActivityMainBinding
import com.example.gpscameratest.databinding.ActivitySearchBinding
import com.moneytracker.moneymanager.moneywallet.activity.base.BaseActivity

class SearchActivity : BaseActivity<ActivitySearchBinding>() {
    override fun getViewBinding(): ActivitySearchBinding {
        return ActivitySearchBinding.inflate(layoutInflater)
    }

    override fun setupViews() {
        super.setupViews()
    }

    override fun setupListeners() {
        super.setupListeners()
    }
}