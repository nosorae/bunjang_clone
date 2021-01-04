package com.nosorae.bunjang_a_mock_android_noah.src.log_in.view_pager

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R

class LogInViewPagerViewHolder(itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    private val itemImage : ImageView = itemView.findViewById(R.id.view_pager_item_log_in)

    fun bindView(pageItem: LogInViewPagerItem){
        itemImage.setImageResource(pageItem.imageSrc)
    }
}