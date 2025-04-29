package com.example.gpscameratest.ui.mybooking

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gpscameratest.R
import com.example.gpscameratest.base.BaseFragment
import com.example.gpscameratest.data.Booking
import com.example.gpscameratest.databinding.FragmentHomeBinding
import com.example.gpscameratest.databinding.FragmentMyBookingBinding
import com.example.gpscameratest.ui.chat.ChatFragment
import com.example.gpscameratest.ui.home.HomeFragment
import com.google.android.material.tabs.TabLayout

class MyBookingFragment :
    BaseFragment<FragmentMyBookingBinding>(FragmentMyBookingBinding::inflate) {

    override fun setUp() {
        initData()
    }


    fun initData() {
        val bookingList = generateDummyData()

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = BookingAdapter(bookingList)


        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // Hành động khi một tab được chọn
                when (tab?.position) {
                    0 -> {
                        // Tab "Booked" được chọn
                        Toast.makeText(context, "Booked selected", Toast.LENGTH_SHORT)
                            .show()
                        // TODO: Load nội dung cho Booked
                    }

                    1 -> {
                        Toast.makeText(context, "History selected", Toast.LENGTH_SHORT)
                            .show()
                        // TODO: Load nội dung cho History
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Hành động khi một tab không còn được chọn (chuyển sang tab khác)
                // Ít khi dùng trực tiếp ở đây trừ khi cần dọn dẹp gì đó
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Hành động khi tab đang được chọn lại được nhấn lần nữa
                // Ví dụ: scroll lên đầu danh sách
                Toast.makeText(context, "${tab?.text} reselected", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }


    private fun generateDummyData(): List<Booking> {
        return List(20) { index ->
            Booking(
                hotelName = "Hotel ${index + 1}",
                hotelLocation = "Location ${index + 1}",
                price = "$${(100..500).random()}/night",
                dates = "12 - 14 Nov 2024",
                guests = "${(1..3).random()} Guests (1 Room)",
                imageResId = R.drawable.img_demo
            )
        }
    }

    companion object {
        fun newInstance(): MyBookingFragment {
            return MyBookingFragment()
        }
    }
}