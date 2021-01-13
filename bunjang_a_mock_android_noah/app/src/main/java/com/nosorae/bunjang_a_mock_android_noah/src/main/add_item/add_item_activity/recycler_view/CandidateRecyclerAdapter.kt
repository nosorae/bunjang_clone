package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.recycler_view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.AddItemActivityView
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.ItemDetailActivityView


class CandidateRecyclerAdapter(private val context: Context?, val itemList: ArrayList<String>, val isUdpate: Int,val forCallBack: AddItemActivityView)
    : RecyclerView.Adapter<CandidateRecyclerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandidateRecyclerHolder {
        return CandidateRecyclerHolder(context!!,
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_candidate, parent, false), isUdpate)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: CandidateRecyclerHolder, position: Int) {
        val remove = holder.itemView.findViewById<TextView>(R.id.recylcer_item_candidate_button_remove)
        remove.setOnClickListener {
            itemList.removeAt(position)
            notifyDataSetChanged()
            forCallBack.onClickDeleteButton()
        }
        holder.bindView(itemList[position])
    }
}