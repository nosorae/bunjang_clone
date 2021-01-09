package com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.view_pager

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.view_pager.LogInViewPagerItem


class ItemDetailPagerHolder(itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    private val itemImage : ImageView = itemView.findViewById(R.id.pager_item_detail_image)

    fun bindView(pageItem: ItemDetailPagerItem){
        itemImage.setImageResource(pageItem.imageSrc)
    }
}