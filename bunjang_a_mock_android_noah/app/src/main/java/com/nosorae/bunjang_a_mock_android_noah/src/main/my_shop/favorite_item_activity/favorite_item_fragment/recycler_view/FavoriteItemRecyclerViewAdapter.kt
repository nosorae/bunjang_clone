package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity.favorite_item_fragment.recycler_view


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R

class FavoriteItemRecyclerViewAdapter(private val context: Context?, val itemList: ArrayList<FavoriteItemRecyclerViewItem>)
    : RecyclerView.Adapter<FavoriteItemRecyclerViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteItemRecyclerViewViewHolder {
        return FavoriteItemRecyclerViewViewHolder(context!!,
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_favorite, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: FavoriteItemRecyclerViewViewHolder, position: Int) {
        holder.bindView(itemList[position])
    }
}