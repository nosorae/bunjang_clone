package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.recycler_view

import android.content.Context
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R


class CandidateRecyclerHolder(context: Context, itemView: View, val isUpdate: Int)
    : RecyclerView.ViewHolder(itemView) {


    val imageUri = itemView.findViewById<ImageView>(R.id.recylcer_item_candidate_image)

    val context = context

    fun bindView(item : String) {

        if(isUpdate == 0) {
            imageUri.setImageURI(Uri.parse(item))
        }
        else {
            Glide.with(context).load(item).into(imageUri)
        }



    }
}