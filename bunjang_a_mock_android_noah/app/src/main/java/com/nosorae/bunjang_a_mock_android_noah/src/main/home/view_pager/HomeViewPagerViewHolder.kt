package com.nosorae.bunjang_a_mock_android_noah.src.main.home.view_pager

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R


class HomeViewPagerViewHolder(itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    private val itemImage : ImageView = itemView.findViewById(R.id.view_pager_item_home)

    fun bindView(pageItem: HomeViewPagerItem){
        itemImage.setImageResource(pageItem.imageSrc)
    }
}