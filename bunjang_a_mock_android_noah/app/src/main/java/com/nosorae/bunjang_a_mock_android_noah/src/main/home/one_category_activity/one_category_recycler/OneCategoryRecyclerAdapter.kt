package com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.one_category_recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.recycler_view.BungaeTalkRecyclerViewHolderViewHolder
import com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.recycler_view.BungaeTalkRecyclerViewItem



class OneCategoryRecyclerAdapter(private val context: Context?, val itemList: ArrayList<OneCategoryRecyclerItem>)
    : RecyclerView.Adapter<OneCategoryRecyclerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OneCategoryRecyclerHolder {
        return OneCategoryRecyclerHolder(context!!,
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_one_category_category, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: OneCategoryRecyclerHolder, position: Int) {
        holder.bindView(itemList[position])
    }
}