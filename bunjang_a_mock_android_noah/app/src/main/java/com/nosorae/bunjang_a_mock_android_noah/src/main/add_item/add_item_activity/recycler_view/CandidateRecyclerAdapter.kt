package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.recycler_view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R


class CandidateRecyclerAdapter(private val context: Context?, val itemList: ArrayList<String>)
    : RecyclerView.Adapter<CandidateRecyclerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandidateRecyclerHolder {
        return CandidateRecyclerHolder(context!!,
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_candidate, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: CandidateRecyclerHolder, position: Int) {
        holder.bindView(itemList[position])
    }
}