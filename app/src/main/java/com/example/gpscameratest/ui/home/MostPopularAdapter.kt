package com.example.gpscameratest.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gpscameratest.R
import com.example.gpscameratest.data.Hotel

class MostPopularAdapter(private val hotelList: List<Hotel>) :
    RecyclerView.Adapter<MostPopularAdapter.HotelViewHolder>() {

    class HotelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgHotel: ImageView = itemView.findViewById(R.id.imageView4)
        val tvName: TextView = itemView.findViewById(R.id.tvNameHotel)
        val tvLocation: TextView = itemView.findViewById(R.id.tvLocationHotel)
        val tvPrice: TextView = itemView.findViewById(R.id.priceHotel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_most_popular, parent, false)
        return HotelViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        val hotel = hotelList[position]
        holder.tvName.text = hotel.name
        holder.tvLocation.text = hotel.location
        holder.tvPrice.text = hotel.price
        holder.imgHotel.setImageResource(hotel.imageResId)
    }

    override fun getItemCount(): Int = hotelList.size
}