package com.example.gpscameratest.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gpscameratest.R
import com.example.gpscameratest.data.Hotel

class RecRecomentAdapter(private val hotelList: List<Hotel>) :
    RecyclerView.Adapter<RecRecomentAdapter.HotelViewHolder>() {

    inner class HotelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.imageView4)
        val tvNameHotel = itemView.findViewById<TextView>(R.id.tvNameHotel)
        val tvLocationHotel = itemView.findViewById<TextView>(R.id.tvLocationHotel)
        val tvPriceHotel = itemView.findViewById<TextView>(R.id.priceHotel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hotel, parent, false)
        return HotelViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        val hotel = hotelList[position]
        holder.imageView.setImageResource(hotel.imageResId)
        holder.tvNameHotel.text = hotel.name
        holder.tvLocationHotel.text = hotel.location
        holder.tvPriceHotel.text = hotel.price
    }

    override fun getItemCount() = 5
}
