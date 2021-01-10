package com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.one_item_recylcer

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.model.OneCategoryResult
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.one_category_recycler.OneCategoryRecyclerHolder
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.one_category_recycler.OneCategoryRecyclerItem



class OneItemRecyclerAdapter(private val context: Context?, val itemList: ArrayList<OneCategoryResult>)
    : RecyclerView.Adapter<OneItemRecyclerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OneItemRecyclerHolder {
        return OneItemRecyclerHolder(context!!,
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_one_category_item, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: OneItemRecyclerHolder, position: Int) {
        holder.bindView(itemList[position])
    }
}