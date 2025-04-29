package com.example.gpscameratest.ui.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gpscameratest.R
import com.example.gpscameratest.base.BaseFragment
import com.example.gpscameratest.base.setOnUnDoubleClickListener
import com.example.gpscameratest.databinding.FragmentProfileBinding
import com.example.gpscameratest.ui.MyFavorite.MyFavoriteActivity
import com.example.gpscameratest.ui.mybooking.BookingAdapter
import com.example.gpscameratest.ui.mybooking.MyBookingFragment
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.Shimmer.AlphaHighlightBuilder
import com.google.android.material.tabs.TabLayout


class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {


    override fun setUp() {
        initData()
    }

    fun initData() {
        binding.btnGithub.setOnClickListener {
            val url = "https://github.com/NguyenMinhVu2607"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        val shimmer =
            AlphaHighlightBuilder()
                .setDuration(2000)
                .setBaseAlpha(1f)
                .setHighlightAlpha(0.6f)
                .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
                .setAutoStart(true)
                .build()

        binding.shimmerLayout.setShimmer(shimmer)
        binding.shimmerLayout.startShimmer()
        binding.btnFav.setOnUnDoubleClickListener {
            val intent = Intent(requireContext(), MyFavoriteActivity::class.java)
            startActivity(intent)
        }

    }

    companion object {
        fun newInstance(): ProfileFragment {
            val args = Bundle()

            val fragment = ProfileFragment()
            fragment.arguments = args
            return fragment
        }
    }
}