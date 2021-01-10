package com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.view_pager

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R


class ItemDetailPagerAdapter(private val context: Context,
                            private var pageList: ArrayList<ItemDetailPagerItem>)
    : RecyclerView.Adapter<ItemDetailPagerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDetailPagerHolder {
        return ItemDetailPagerHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.view_pager_item_item_detail, parent, false
                ), context
        )
    }

    override fun getItemCount(): Int {
        return pageList.size
    }

    override fun onBindViewHolder(holder: ItemDetailPagerHolder, position: Int) {
        holder.bindView(pageList[position])
    }
}