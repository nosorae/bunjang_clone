package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.recycler_view

import android.content.Context
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R

class GalleryRecyclerViewViewHolder(context: Context, itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val imageUri = itemView.findViewById<ImageView>(R.id.recycler_view_item_gallery_image)

    val context = context
    fun bindView(item : GalleryRecyclerViewItem) {
        imageUri.setImageURI(Uri.parse(item.imageUri))
    }
}