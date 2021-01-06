package com.nosorae.bunjang_a_mock_android_noah.src.main.home.collection_dialog

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.Result

class CollectionRecyclerViewAdapter(private val context: Context?, val itemList: ArrayList<Result>)
    : RecyclerView.Adapter<CollectionRecyclerViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionRecyclerViewViewHolder {
        return CollectionRecyclerViewViewHolder(context!!,
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_collections, parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: CollectionRecyclerViewViewHolder, position: Int) {
        holder.bindView(itemList[position])
    }
}