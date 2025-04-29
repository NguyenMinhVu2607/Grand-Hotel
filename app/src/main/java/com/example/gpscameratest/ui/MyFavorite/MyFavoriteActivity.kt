package com.example.gpscameratest.ui.MyFavorite

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gpscameratest.R
import com.example.gpscameratest.data.Hotel
import com.example.gpscameratest.databinding.ActivityDetailRoomBinding
import com.example.gpscameratest.databinding.ActivityMyFavoriteBinding
import com.moneytracker.moneymanager.moneywallet.activity.base.BaseActivity

class MyFavoriteActivity : BaseActivity<ActivityMyFavoriteBinding>(){
    override fun getViewBinding(): ActivityMyFavoriteBinding {
        return ActivityMyFavoriteBinding.inflate(layoutInflater)
    }

    override fun setupListeners() {
        super.setupListeners()
    }

    override fun setupViews() {
        super.setupViews()
        binding.recFav.layoutManager = GridLayoutManager(this, 2)

        val hotelList = listOf(
            Hotel("Elinate Galian Hotel", "Chestnut StreetRome, NY", "$248 Per Night", 4.5, R.drawable.img_demo),
            Hotel("Sunset Beach Resort", "Miami Beach, FL", "$189 Per Night", 4.5, R.drawable.img_demo),
            Hotel("Mountain Peak Lodge", "Aspen, CO", "$350 Per Night", 4.5, R.drawable.img_demo),
            Hotel("Golden Sands Hotel", "Los Angeles, CA", "$299 Per Night", 4.5, R.drawable.img_demo),
            Hotel("Elinate Galian Hotel", "Chestnut StreetRome, NY", "$248 Per Night", 4.5, R.drawable.img_demo),
            Hotel("Sunset Beach Resort", "Miami Beach, FL", "$189 Per Night", 4.5, R.drawable.img_demo),
            Hotel("Mountain Peak Lodge", "Aspen, CO", "$350 Per Night", 4.5, R.drawable.img_demo),
            Hotel("Golden Sands Hotel", "Los Angeles, CA", "$299 Per Night", 4.5, R.drawable.img_demo),
            Hotel("Elinate Galian Hotel", "Chestnut StreetRome, NY", "$248 Per Night", 4.5, R.drawable.img_demo),
            Hotel("Sunset Beach Resort", "Miami Beach, FL", "$189 Per Night", 4.5, R.drawable.img_demo),
            Hotel("Mountain Peak Lodge", "Aspen, CO", "$350 Per Night", 4.5, R.drawable.img_demo),
            Hotel("Golden Sands Hotel", "Los Angeles, CA", "$299 Per Night", 4.5, R.drawable.img_demo)
        )

        val hotelAdapter = HotelAdapter(hotelList)
        binding.recFav.adapter = hotelAdapter
    }
}