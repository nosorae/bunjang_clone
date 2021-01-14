package com.nosorae.bunjang_a_mock_android_noah.src.main.following.recommend_fragment.recycler

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.recommend_fragment.model.GetRecommendResult


class RecommendRecyclerHolder(context: Context, itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val imgId = itemView.findViewById<ImageView>(R.id.recycle_recommend_profile_image)
    val nameId = itemView.findViewById<TextView>(R.id.recycle_recommend_profile_name)
    val sellingId = itemView.findViewById<TextView>(R.id.recycle_recommend_num_of_selling)
    val followerId = itemView.findViewById<TextView>(R.id.recycle_recommend_num_of_follower)
    //val isFollowImgId = itemView.findViewById<TextView>(R.id.recycle_recommend_is_follow)
    val productImg1Id = itemView.findViewById<ImageView>(R.id.recycle_recommend_product_image1)
    val productImg2Id = itemView.findViewById<ImageView>(R.id.recycle_recommend_product_image2)
    val productImg3Id = itemView.findViewById<ImageView>(R.id.recycle_recommend_product_image3)
    val productPrice1Id = itemView.findViewById<TextView>(R.id.recycle_recommend_product_price1)
    val productPrice2Id = itemView.findViewById<TextView>(R.id.recycle_recommend_product_price2)
    val productPrice3Id = itemView.findViewById<TextView>(R.id.recycle_recommend_product_price3)
    val context = context

    fun bindView(item : GetRecommendResult) {
        if(item.storeImgUrl != null) {
            Glide.with(context).load(item.storeImgUrl).into(imgId)
        }

        nameId.text = item.storeName
        sellingId.text =item.productCount.toString()
        followerId.text = item.followerCount.toString()

        Glide.with(context).load(item.products[0].productImgUrl).into(productImg1Id)
        Glide.with(context).load(item.products[1].productImgUrl).into(productImg2Id)
        Glide.with(context).load(item.products[2].productImgUrl).into(productImg3Id)
        productPrice1Id.text = item.products[0].price.toString()
        productPrice2Id.text = item.products[1].price.toString()
        productPrice3Id.text = item.products[2].price.toString()

    }
}