package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.recycler_view


import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model.GetFavoriteCollectionResult

class FavoriteItemRecyclerHolder(context: Context, itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val image = itemView.findViewById<ImageView>(R.id.favorite_item_image)
    val name = itemView.findViewById<TextView>(R.id.favorite_item_text_name)
    val num = itemView.findViewById<TextView>(R.id.favorite_item_text_num)

    val context = context
    fun bindView(item : GetFavoriteCollectionResult) {
        if(item.lastPickImg != null){
            Glide.with(context).load(item.lastPickImg).into(image)
        }
        else {
            image.setImageResource(R.drawable.collection_default)
        }

        name.text  = item.collectionName
        num.text = item.pickCount.toString()
    }
}