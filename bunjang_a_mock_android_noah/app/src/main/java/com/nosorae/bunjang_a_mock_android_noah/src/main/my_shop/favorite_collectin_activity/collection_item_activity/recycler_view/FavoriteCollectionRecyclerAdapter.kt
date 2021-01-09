package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_item_activity.recycler_view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_item_activity.model.FavoriteCollectionItemResult


class FavoriteCollectionRecyclerAdapter(private val context: Context?, val itemList: ArrayList<FavoriteCollectionItemResult>)
    : RecyclerView.Adapter<FavoriteCollectionRecyclerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteCollectionRecyclerHolder {
        return FavoriteCollectionRecyclerHolder(context!!,
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_collection_detail_list, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: FavoriteCollectionRecyclerHolder, position: Int) {
        holder.bindView(itemList[position])
    }
}