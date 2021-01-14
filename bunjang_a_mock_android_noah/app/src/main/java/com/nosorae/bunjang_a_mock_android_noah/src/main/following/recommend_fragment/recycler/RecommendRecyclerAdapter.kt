package com.nosorae.bunjang_a_mock_android_noah.src.main.following.recommend_fragment.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.recommend_fragment.model.GetRecommendResult


class RecommendRecyclerAdapter(private val context: Context?, val itemList: ArrayList<GetRecommendResult>)
    : RecyclerView.Adapter<RecommendRecyclerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendRecyclerHolder {
        return RecommendRecyclerHolder(context!!,
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_recommend_item, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecommendRecyclerHolder, position: Int) {
        holder.bindView(itemList[position])
    }
}