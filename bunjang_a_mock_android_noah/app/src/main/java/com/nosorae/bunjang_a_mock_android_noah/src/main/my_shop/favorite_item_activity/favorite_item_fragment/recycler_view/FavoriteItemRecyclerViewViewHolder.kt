package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity.favorite_item_fragment.recycler_view

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view.HomeRecyclerViewItem
import org.w3c.dom.Text

class FavoriteItemRecyclerViewViewHolder(context: Context, itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val image = itemView.findViewById<ImageView>(R.id.favorite_item_image)
    val name = itemView.findViewById<TextView>(R.id.favorite_item_text_name)
    val num = itemView.findViewById<TextView>(R.id.favorite_item_text_num)

    val context = context
    fun bindView(item : FavoriteItemRecyclerViewItem) {
        Glide.with(context).load(item.imageUrl).into(image)
        name.text  = item.name
        num.text = item.num.toString()
    }
}