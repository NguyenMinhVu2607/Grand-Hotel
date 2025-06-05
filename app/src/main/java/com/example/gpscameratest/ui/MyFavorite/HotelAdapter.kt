package com.example.gpscameratest.ui.MyFavorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gpscameratest.R
import com.example.gpscameratest.data.Hotel

class HotelAdapter(private val hotelList: List<Hotel>) : RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favourite, parent, false)
        return HotelViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        val hotel = hotelList[position]
        holder.tvHotelName.text = hotel.name
        holder.tvLocation.text = hotel.location
        holder.tvPrice.text = hotel.price
        holder.tvRating.text = hotel.rating.toString()
        holder.imageViewHotel.setImageResource(hotel.imageResId)
    }

    override fun getItemCount(): Int = hotelList.size

    inner class HotelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvHotelName: TextView = itemView.findViewById(R.id.tvHotelName)
        val tvLocation: TextView = itemView.findViewById(R.id.tvLocation)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val tvRating: TextView = itemView.findViewById(R.id.tvRating)
        val imageViewHotel: ImageView = itemView.findViewById(R.id.imageViewHotel)
        val imageViewFavorite: ImageView = itemView.findViewById(R.id.imageViewFavorite)
    }
}
