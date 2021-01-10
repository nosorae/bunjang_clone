package com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.recycler_selling_item

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.Sale


class SellingRecyclerAdapter(private val context: Context?, val itemList: ArrayList<Sale>)
    : RecyclerView.Adapter<SellingRcyclerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SellingRcyclerHolder {
        return SellingRcyclerHolder(context!!,
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_other_item, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: SellingRcyclerHolder, position: Int) {
        holder.bindView(itemList[position])
    }
}