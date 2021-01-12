package com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.recycler_view

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R


class BungaeTalkRecyclerViewHolderViewHolder(context: Context, itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val imgId = itemView.findViewById<ImageView>(R.id.recycler_bungae_seller_image)
    val nameId = itemView.findViewById<TextView>(R.id.recycler_bungae_seller_name)
    val recentTalkId = itemView.findViewById<TextView>(R.id.recycler_bungae_recent_talk)
    val timeId = itemView.findViewById<TextView>(R.id.recycler_bungae_recent_talk_time)
    val notificationId = itemView.findViewById<TextView>(R.id.recycler_bungae_notification)
    val context = context

    fun bindView(item : BungaeTalkRecyclerViewItem) {
        Glide.with(context).load(item.imgUrl).into(imgId)
        nameId.text = item.name
        recentTalkId.text = item.recent
        timeId.text = item.time
        if(item.num == 0) {
            notificationId.visibility = View.INVISIBLE
        } else {
            notificationId.text = item.num.toString()
        }

    }
}