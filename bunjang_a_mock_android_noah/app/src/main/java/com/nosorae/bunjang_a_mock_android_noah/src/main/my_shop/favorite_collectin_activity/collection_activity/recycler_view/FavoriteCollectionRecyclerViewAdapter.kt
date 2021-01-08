package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_activity.recycler_view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_activity.model.FavoriteCollectionResult


class FavoriteCollectionRecyclerViewAdapter(private val context: Context?, val itemList: ArrayList<FavoriteCollectionResult>)
    : RecyclerView.Adapter<FavoriteCollectionRecyclerViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteCollectionRecyclerViewViewHolder {
        return FavoriteCollectionRecyclerViewViewHolder(context!!,
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_collection_detail_list, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: FavoriteCollectionRecyclerViewViewHolder, position: Int) {
        holder.bindView(itemList[position])
    }
}