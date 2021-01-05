package com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R

class HomeRecyclerViewViewHolder(context: Context, itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val imageUrl = itemView.findViewById<ImageView>(R.id.home_item_image_item_image)
    val itemName = itemView.findViewById<TextView>(R.id.home_item_text_view_name)
    val itemPrice = itemView.findViewById<TextView>(R.id.home_item_text_view_price)
    val itemFavorite = itemView.findViewById<ImageView>(R.id.home_item_image_favorite)
    val context = context
    fun bindView(item : HomeRecyclerViewItem) {
        Glide.with(context).load(item.imageURL).into(imageUrl)
        //imageUrl.setImageResource(R.drawable.home_banner1)
        //"https://www.juso.go.kr/img/content/know_addr_1.png"
        itemName.text = item.name
        itemPrice.text = item.price.toString()
        if(item.isPick == 1){
            itemFavorite.setImageResource(R.drawable.home_favorite_selected)
        }
        else{
            itemFavorite.setImageResource(R.drawable.home_favorite_default)
        }





    }
}