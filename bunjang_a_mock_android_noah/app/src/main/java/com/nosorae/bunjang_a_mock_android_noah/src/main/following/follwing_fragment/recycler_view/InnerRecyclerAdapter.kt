package com.nosorae.bunjang_a_mock_android_noah.src.main.following.follwing_fragment.recycler_view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.recycler_view.BungaeTalkRecyclerViewHolderViewHolder
import com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.recycler_view.BungaeTalkRecyclerViewItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.follwing_fragment.model.GetInnerResult


class InnerRecyclerAdapter(private val context: Context?, val itemList: ArrayList<GetInnerResult>)
    : RecyclerView.Adapter<InnerRecyclerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerRecyclerHolder {
        return InnerRecyclerHolder(context!!,
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_inner_following, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: InnerRecyclerHolder, position: Int) {
        holder.bindView(itemList[position])
    }
}