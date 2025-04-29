package com.example.gpscameratest.ui.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gpscameratest.R

class ChatAdapter(private val chatList: List<ChatItem>) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgAvatar: ImageView = itemView.findViewById(R.id.img_avatar)
        val tvUsername: TextView = itemView.findViewById(R.id.tv_username)
        val tvLastMessage: TextView = itemView.findViewById(R.id.tv_last_message)
        val tvUnreadCount: TextView = itemView.findViewById(R.id.tv_unread_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val item = chatList[position]

        holder.imgAvatar.setImageResource(item.avatarResId)
        holder.tvUsername.text = item.username
        holder.tvLastMessage.text = item.lastMessage

        if (item.unreadCount > 0) {
            holder.tvUnreadCount.visibility = View.VISIBLE
            holder.tvUnreadCount.text = item.unreadCount.toString()
        } else {
            holder.tvUnreadCount.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int = chatList.size
}
