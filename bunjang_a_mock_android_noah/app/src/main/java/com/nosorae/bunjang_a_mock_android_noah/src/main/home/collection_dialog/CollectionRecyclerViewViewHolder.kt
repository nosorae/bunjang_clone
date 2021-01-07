package com.nosorae.bunjang_a_mock_android_noah.src.main.home.collection_dialog

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.Result

class CollectionRecyclerViewViewHolder (val context: Context, itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val imageUrl = itemView.findViewById<ImageView>(R.id.collection_list_image)
    val itemName = itemView.findViewById<TextView>(R.id.collection_list_text_view_name)
    val itemNum = itemView.findViewById<TextView>(R.id.collection_list_text_view_num)



    fun bindView(item : Result) {
        Glide.with(context).load(item.lastPickImg).into(imageUrl)
        itemName.text = item.collectionName
        itemNum.text =item.pickCount.toString()

    }
}

