package com.example.gpscameratest.ui.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gpscameratest.R
import com.example.gpscameratest.base.gone
import com.example.gpscameratest.base.visible
import com.example.gpscameratest.databinding.ItemOnboardingBinding

class OnboardingAdapter(
    private val items: List<OnboardingItem>,
    private val onNextClick: (Int) -> Unit
) : RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    inner class OnboardingViewHolder(private val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: OnboardingItem, position: Int) {
            binding.imageView.setImageResource(item.imageResId)
            binding.textTitle.text = item.title
            binding.textDescription.text = item.description
            binding.buttonNext.text = if (position == items.lastIndex) "Get Started" else "Continue"
            if (position == items.lastIndex) {
                binding.tabIndicator.gone()
            } else {
                binding.tabIndicator.visible()
                binding.tabIndicator.setImageResource(
                    if (position == 0) R.drawable.slider1 else R.drawable.slider2
                )
            }
            binding.buttonNext.setOnClickListener {
                onNextClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val binding = ItemOnboardingBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return OnboardingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    override fun getItemCount(): Int = items.size
}
