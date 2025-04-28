package com.example.gpscameratest.ui.mybooking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gpscameratest.R
import com.example.gpscameratest.data.Booking

class BookingAdapter(private val bookingList: List<Booking>) : RecyclerView.Adapter<BookingAdapter.BookingViewHolder>() {

    // ViewHolder để ánh xạ các view trong item layout
    inner class BookingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hotelName: TextView = itemView.findViewById(R.id.tvHotelName)
        val hotelLocation: TextView = itemView.findViewById(R.id.tvHotelLocation)
        val price: TextView = itemView.findViewById(R.id.tvHotelPrice)
        val dates: TextView = itemView.findViewById(R.id.tvDates)
        val guests: TextView = itemView.findViewById(R.id.tvGuests)
        val hotelImage: ImageView = itemView.findViewById(R.id.imgHotel)
    }

    // Tạo view holder cho mỗi item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_booking, parent, false)
        return BookingViewHolder(view)
    }

    // Ràng buộc dữ liệu vào view holder
    override fun onBindViewHolder(holder: BookingViewHolder, position: Int) {
        val booking = bookingList[position]

        holder.hotelName.text = booking.hotelName
        holder.hotelLocation.text = booking.hotelLocation
        holder.price.text = booking.price
        holder.dates.text = booking.dates
        holder.guests.text = booking.guests
        holder.hotelImage.setImageResource(booking.imageResId)
    }

    // Trả về số lượng items
    override fun getItemCount(): Int {
        return bookingList.size
    }
}
