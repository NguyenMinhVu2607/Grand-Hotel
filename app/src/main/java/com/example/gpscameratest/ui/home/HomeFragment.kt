package com.example.gpscameratest.ui.home

import android.app.Activity
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gpscameratest.R
import com.example.gpscameratest.base.BaseFragment
import com.example.gpscameratest.data.Hotel
import com.example.gpscameratest.databinding.FragmentHomeBinding
import com.example.gpscameratest.ui.detail.DetailRoomActivity
import com.example.gpscameratest.ui.search.SearchActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import kotlin.reflect.KClass


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun setUp() {
        initData()

        binding.mapView.onCreate(null)
        binding.mapView.getMapAsync { googleMap ->
            googleMap.uiSettings.isZoomControlsEnabled = true
            val haNoi = LatLng(21.028511, 105.804817)
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(haNoi, 12f))
        }
        binding.ivSearch.setOnClickListener { startNewActivity(SearchActivity::class, false) }
    }


    public fun initData() {
        val hotelList = listOf(
            Hotel("The Horizon Retreat", "Los Angeles, CA", "$480/night", 4.5, R.drawable.img_demo),
            Hotel("Sea Breeze Hotel", "Miami, FL", "$350/night", 4.5, R.drawable.img_demo),
            Hotel("Mountain View Inn", "Denver, CO", "$400/night", 4.5, R.drawable.img_demo),
            Hotel("Urban Escape", "New York, NY", "$600/night", 4.5, R.drawable.img_demo),
            Hotel("Palm Paradise", "Honolulu, HI", "$520/night", 4.5, R.drawable.img_demo),
            Hotel("Royal Stay", "Las Vegas, NV", "$450/night", 4.5, R.drawable.img_demo),
            Hotel("Sunset Resort", "San Diego, CA", "$390/night", 4.5, R.drawable.img_demo),
            Hotel("Lakeside Lodge", "Lake Tahoe, CA", "$470/night", 4.5, R.drawable.img_demo),
            Hotel("Countryside Inn", "Nashville, TN", "$320/night", 4.5, R.drawable.img_demo),
        )
        val adapter = MostPopularAdapter(hotelList)
        binding.recMostPopular.adapter = adapter
        binding.recRecoment.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapterRecoment = RecRecomentAdapter(hotelList) { selectedHotel ->
            val intent = Intent(requireContext(), DetailRoomActivity::class.java)
            intent.putExtra("HOTEL_NAME", selectedHotel.name)
            intent.putExtra("HOTEL_IMAGE", selectedHotel.imageResId)
            intent.putExtra("HOTEL_LOCATION", selectedHotel.location)
            intent.putExtra("HOTEL_PRICE", selectedHotel.price)
            startActivity(intent)
        }

        binding.recRecoment.adapter = adapterRecoment
    }

    fun startNewActivity(activityClass: KClass<out Activity>, isFinish: Boolean = false) {
        val intent = Intent(requireContext(), activityClass.java)
        startActivity(intent)
        if (isFinish) {
            requireActivity().finish()
        }
    }


    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}
