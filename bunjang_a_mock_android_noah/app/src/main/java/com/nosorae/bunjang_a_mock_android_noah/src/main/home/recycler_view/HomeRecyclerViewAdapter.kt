package com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R

class HomeRecyclerViewAdapter(private val context: Context?, val itemList: ArrayList<HomeRecyclerViewItem>)
    : RecyclerView.Adapter<HomeRecyclerViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewViewHolder {
        return HomeRecyclerViewViewHolder(context!!,
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_home, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: HomeRecyclerViewViewHolder, position: Int) {
        holder.bindView(itemList[position])
    }
}