package com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.one_category_recycler

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.recycler_view.BungaeTalkRecyclerViewItem


class OneCategoryRecyclerHolder(context: Context, itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val nameId = itemView.findViewById<TextView>(R.id.recycler_category_category_name)
    val numId = itemView.findViewById<TextView>(R.id.recycler_category_category_num)

    val context = context

    fun bindView(item : OneCategoryRecyclerItem) {
      nameId.text = item.name
      numId.text = item.num.toString()
    }
}