package com.example.gpscameratest.ui.detail

import android.animation.Animator
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gpscameratest.R
import com.example.gpscameratest.databinding.ActivityRequestBookingBinding
import com.moneytracker.moneymanager.moneywallet.activity.base.BaseActivity

class RequestBookingActivity : BaseActivity<ActivityRequestBookingBinding>() {




    override fun getViewBinding(): ActivityRequestBookingBinding {
        return ActivityRequestBookingBinding.inflate(layoutInflater)
    }

    override fun setupViews() {
        super.setupViews()
        binding.Checkout.setOnClickListener {
            binding.Checkout.isEnabled = false
            binding.lottieView.visibility = View.VISIBLE
            binding.lottieView.playAnimation()

            binding.lottieView.addAnimatorListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}
                override fun onAnimationRepeat(animation: Animator) {}
                override fun onAnimationCancel(animation: Animator) {}

                override fun onAnimationEnd(animation: Animator) {
                    finish()
                }
            })
        }
    }

    override fun setupListeners() {
        super.setupListeners()
    }
}