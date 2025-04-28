package com.example.gpscameratest

import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.gpscameratest.adapter.ViewPagerAddFragmentsAdapter
import com.example.gpscameratest.base.setOnUnDoubleClickListener
import com.example.gpscameratest.databinding.ActivityMainBinding
import com.example.gpscameratest.permisssion.PermissionCallback
import com.example.gpscameratest.permisssion.PermissionManager
import com.example.gpscameratest.ui.chat.ChatFragment
import com.example.gpscameratest.ui.home.HomeFragment
import com.example.gpscameratest.ui.mybooking.MyBookingFragment
import com.example.gpscameratest.ui.profile.ProfileFragment

import com.moneytracker.moneymanager.moneywallet.activity.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(), PermissionCallback {
    private val homeFragment: HomeFragment by lazy { HomeFragment.newInstance() }
    private val myBookingFragment: MyBookingFragment by lazy { MyBookingFragment.newInstance() }
    private val chatFragment: ChatFragment by lazy { ChatFragment.newInstance() }
    private val profileFragment: ProfileFragment by lazy { ProfileFragment.newInstance() }

    private lateinit var permissionManager: PermissionManager
    var isUserMove = true

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupViews() {
        super.setupViews()
        permissionManager = PermissionManager(this)
        binding.vpHome.apply {
            adapter = ViewPagerAddFragmentsAdapter(supportFragmentManager, lifecycle).apply {
                addFrag(homeFragment)
                addFrag(myBookingFragment)
                addFrag(chatFragment)
                addFrag(profileFragment)
            }
            isUserInputEnabled = false
            offscreenPageLimit = 4
            setCurrentItem(0, true)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    selectBottomNavBar(position)
                }
            })
        }
        setOnClick()
    }

    private fun setOnClick() {
        binding.btnHome.setOnUnDoubleClickListener {
            if (binding.vpHome.currentItem != 0) {
                homeFragment.initData()

                showInterTab(0)
            }
        }
        binding.btnStatistics.setOnUnDoubleClickListener {
            if (binding.vpHome.currentItem != 1) {
                myBookingFragment.initData()
                showInterTab(1)
            }
        }
        binding.btnBudget.setOnUnDoubleClickListener {
            if (binding.vpHome.currentItem != 2) {
                chatFragment.initData()

                showInterTab(2)
            }
        }
        binding.btnSetting.setOnUnDoubleClickListener {
            if (binding.vpHome.currentItem != 3)
                showInterTab(3)
        }

    }

    private fun showInterTab(pos: Int) {
        isUserMove = true
        binding.vpHome.setCurrentItem(pos, true)
    }

    private fun selectBottomNavBar(position: Int) {
        binding.icHome.setImageResource(R.drawable.ic_home_unselect)
        binding.tvHome.setTextColor(ContextCompat.getColor(this, R.color.color_78828A))

        binding.icAdditional.setImageResource(R.drawable.ic_booking_unselect)
        binding.tvAdditional.setTextColor(ContextCompat.getColor(this, R.color.color_78828A))

        binding.icCompare.setImageResource(R.drawable.ic_message_unselect)
        binding.tvCompare.setTextColor(ContextCompat.getColor(this, R.color.color_78828A))

        binding.icSetting.setImageResource(R.drawable.ic_profile_unselect)
        binding.tvSetting.setTextColor(ContextCompat.getColor(this, R.color.color_78828A))
        when (position) {
            0 -> {
                binding.icHome.setImageResource(R.drawable.ic_home_select)
                binding.tvHome.setTextColor(ContextCompat.getColor(this, R.color.main_color))
            }

            1 -> {
                binding.icAdditional.setImageResource(R.drawable.ic_booking_select)
                binding.tvAdditional.setTextColor(ContextCompat.getColor(this, R.color.main_color))
            }

            2 -> {
                binding.icCompare.setImageResource(R.drawable.ic_message_select)
                binding.tvCompare.setTextColor(ContextCompat.getColor(this, R.color.main_color))
            }

            3 -> {
                binding.icSetting.setImageResource(R.drawable.ic_profile_select)
                binding.tvSetting.setTextColor(ContextCompat.getColor(this, R.color.main_color))
            }
        }
    }

    override fun onPermissionGranted() {

    }

    override fun onPermissionDenied(deniedPermissions: List<String>) {
        Toast.makeText(
            this,
            "Quyền bị từ chối: ${deniedPermissions.joinToString()}",
            Toast.LENGTH_SHORT
        ).show()
    }
}
