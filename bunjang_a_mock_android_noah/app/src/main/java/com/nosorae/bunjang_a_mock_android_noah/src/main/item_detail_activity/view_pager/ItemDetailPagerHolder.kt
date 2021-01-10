package com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.view_pager

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.view_pager.LogInViewPagerItem


class ItemDetailPagerHolder(itemView: View, val context: Context)
    : RecyclerView.ViewHolder(itemView) {

    private val itemImage : ImageView = itemView.findViewById(R.id.pager_item_detail_image)

    fun bindView(pageItem: ItemDetailPagerItem){
        Glide.with(context).load(pageItem.imageUrl).into(itemImage)
    }
}