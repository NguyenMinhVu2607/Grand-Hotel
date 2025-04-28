package com.example.gpscameratest.ui.detail

import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.widget.NestedScrollView
import com.example.gpscameratest.R
import com.example.gpscameratest.databinding.ActivityDetailRoomBinding
import com.google.android.material.appbar.AppBarLayout
import com.moneytracker.moneymanager.moneywallet.activity.base.BaseActivity
import kotlin.math.abs
import kotlin.math.max


class DetailRoomActivity : BaseActivity<ActivityDetailRoomBinding>(),
    AppBarLayout.OnOffsetChangedListener {

    private var isCalculated = false
    private var titleTargetTranslationX = 0f

    override fun getViewBinding(): ActivityDetailRoomBinding {
        return ActivityDetailRoomBinding.inflate(layoutInflater)
    }

    override fun setupViews() {
        super.setupViews()
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
        binding.toolbarTitle.alpha = 0f
        binding.toolbarTitle.translationX = 0f

        binding.toolbar.post {
            calculateTitleTargetTranslation()
        }
        binding.nestedScrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { nestedScrollView, scrollX, scrollY, oldScrollX, oldScrollY ->
            Log.e(
                "ProductFragment",
                "position button $oldScrollX scrollY $scrollY"
            )

            val scrollViewHeight = nestedScrollView.height
            val childView = nestedScrollView.getChildAt(0)
            val scrollRange: Int = childView?.height ?: 0 - scrollViewHeight
            val scrollPercentage = scrollY.toFloat() / scrollRange.toFloat()


            val params = binding.scrollingButton.layoutParams as CoordinatorLayout.LayoutParams
            binding.scrollingButton.layoutParams = params

            // Tính toán độ mờ (alpha) cho nút, bắt đầu từ 10% (alpha = 0.1) và dần đậm lên 100% (alpha = 1)
            val alpha = scrollPercentage.coerceIn(0f, 1f) // Đảm bảo alpha nằm trong khoảng từ 0 đến 1
            binding.scrollingButton.alpha = (alpha * 0.1f + 0.9f) // Đảm bảo nút luôn có alpha ít nhất 0.5 khi bắt đầu

            // Hiển thị nút nếu có cuộn, ẩn nó khi cuộn lên và về vị trí đầu (scrollY == 0)
            if (scrollY > 0) {
                binding.scrollingButton.visibility = View.VISIBLE
            } else {
                binding.scrollingButton.visibility = View.GONE
            }
        })



    }

    private fun calculateTitleTargetTranslation() {
        if (binding.toolbar.width > 0 && binding.toolbarTitle.width > 0 && !isCalculated) {
            val targetCenterX = binding.toolbar.width / 2f
            val titleHalfWidth = binding.toolbarTitle.width / 2f
            val initialStartX = binding.toolbarTitle.left.toFloat()
            val offsetFromCenter = 20f

            titleTargetTranslationX =
                targetCenterX - titleHalfWidth - initialStartX - offsetFromCenter
            isCalculated = true
        }
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
        val maxScroll = appBarLayout.totalScrollRange
        if (maxScroll == 0) return
        val percentage = abs(verticalOffset).toFloat() / maxScroll.toFloat()
        if (!isCalculated && binding.toolbar.width > 0 && binding.toolbarTitle.width > 0) {
            calculateTitleTargetTranslation()
        }
        if (isCalculated) {
            binding.toolbarTitle.translationX = max(0f, titleTargetTranslationX * percentage)
            binding.toolbarTitle.alpha = percentage
        } else {
            binding.toolbarTitle.alpha = 0f
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        binding.appBarLayout.addOnOffsetChangedListener(this)
    }

    override fun onPause() {
        super.onPause()
        binding.appBarLayout.removeOnOffsetChangedListener(this)
    }


}