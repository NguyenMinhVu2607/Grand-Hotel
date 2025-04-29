package com.example.gpscameratest.ui.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gpscameratest.R
import com.example.gpscameratest.base.BaseFragment
import com.example.gpscameratest.databinding.FragmentChatBinding
import com.example.gpscameratest.databinding.FragmentProfileBinding

class ChatFragment : BaseFragment<FragmentChatBinding>(FragmentChatBinding::inflate) {
    override fun setUp() {
        initData()
    }

    fun initData() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = ChatAdapter(fakeChats)

    }

    companion object {
        fun newInstance(): ChatFragment {
            val args = Bundle()

            val fragment = ChatFragment()
            fragment.arguments = args
            return fragment
        }
    }

    val fakeChats = listOf(
        ChatItem(R.drawable.ic_avt, "Nguyễn Văn A", "Xin chào!", 3),
        ChatItem(R.drawable.ic_avt, "Trần Thị B", "Cảm ơn bạn 😁", 0),
        ChatItem(R.drawable.ic_avt, "Lê Minh C", "Hẹn gặp lại.", 1),
        ChatItem(R.drawable.ic_avt, "Trần Thị B", "Cảm ơn bạn 😁", 0),
        ChatItem(R.drawable.ic_avt, "Lê Minh C", "Hẹn gặp lại.", 1),
        ChatItem(R.drawable.ic_avt, "Lê Minh C", "Hẹn gặp lại.", 1),
        ChatItem(R.drawable.ic_avt, "Trần Thị B", "Cảm ơn bạn 😁", 0),
        ChatItem(R.drawable.ic_avt, "Lê Minh C", "Hẹn gặp lại.", 1),
        ChatItem(R.drawable.ic_avt, "Trần Thị B", "Cảm ơn bạn 😁", 0),
        ChatItem(R.drawable.ic_avt, "Lê Minh C", "Hẹn gặp lại.", 1),
        ChatItem(R.drawable.ic_avt, "Phạm Văn D", "Đã xem.", 0)
    )

}