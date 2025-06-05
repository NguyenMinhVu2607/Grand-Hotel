package com.example.gpscameratest.ui.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.gpscameratest.MainActivity
import com.example.gpscameratest.R
import com.example.gpscameratest.databinding.ActivityOnboardingBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.moneytracker.moneymanager.moneywallet.activity.base.BaseActivity

class OnboardingActivity : BaseActivity<ActivityOnboardingBinding>() {

    override fun getViewBinding(): ActivityOnboardingBinding {
        return ActivityOnboardingBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val onboardingItems = listOf(
            OnboardingItem(
                R.drawable.bg1,
                "Luxury and Comfort, \n" +
                        "Just a Tap Away",
                "Semper in cursus magna et eu varius nunc adipiscing. Elementum justo, laoreet id sem . "
            ),
            OnboardingItem(
                R.drawable.bg2,
                "Book with Ease, Stay \n" +
                        "with Style",
                "Semper in cursus magna et eu varius nunc adipiscing. Elementum justo, laoreet id sem . "
            ),
            OnboardingItem(
                R.drawable.bg3,
                "Discover Your Dream Hotel, Effortlessly",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
            )
        )

        val adapter = OnboardingAdapter(onboardingItems) { position ->
            if (position == onboardingItems.lastIndex) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                binding.viewPager.currentItem = position + 1
            }
        }

        binding.viewPager.adapter = adapter
    }
}
