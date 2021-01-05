package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.recycler_view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R

class GalleryRecyclerViewAdapter(private val context: Context?, val itemList: ArrayList<GalleryRecyclerViewItem>)
    : RecyclerView.Adapter<GalleryRecyclerViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryRecyclerViewViewHolder {
        return GalleryRecyclerViewViewHolder(context!!,
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_gallery, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: GalleryRecyclerViewViewHolder, position: Int) {
        holder.bindView(itemList[position])
    }
}