package com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.recycler_view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R


class BungaeTalkRecyclerViewAdapter(private val context: Context?, val itemList: ArrayList<BungaeTalkRecyclerViewItem>)
    : RecyclerView.Adapter<BungaeTalkRecyclerViewHolderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BungaeTalkRecyclerViewHolderViewHolder {
        return BungaeTalkRecyclerViewHolderViewHolder(context!!,
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_bungae_talk, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: BungaeTalkRecyclerViewHolderViewHolder, position: Int) {
        holder.bindView(itemList[position])
    }
}