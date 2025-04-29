package com.example.gpscameratest.ui.chat

data class ChatItem(
    val avatarResId: Int,
    val username: String,
    val lastMessage: String,
    val unreadCount: Int
)
