package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.recycler_view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.GetMySellingResult


class MySellingRecyclerAdapter(private val context: Context?, val itemList: ArrayList<GetMySellingResult>)
    : RecyclerView.Adapter<MySellingRecyclerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MySellingRecyclerHolder {
        return MySellingRecyclerHolder(context!!,
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_my_selling, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MySellingRecyclerHolder, position: Int) {
        holder.bindView(itemList[position])
    }
}