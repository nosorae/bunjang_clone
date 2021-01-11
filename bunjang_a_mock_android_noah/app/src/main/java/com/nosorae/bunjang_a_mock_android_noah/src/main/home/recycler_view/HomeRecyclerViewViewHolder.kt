package com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResult

class HomeRecyclerViewViewHolder(context: Context, itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val imageUrl = itemView.findViewById<ImageView>(R.id.home_item_image_item_image)
    val itemName = itemView.findViewById<TextView>(R.id.home_item_text_view_name)
    val itemPrice = itemView.findViewById<TextView>(R.id.home_item_text_view_price)
    val itemFavorite = itemView.findViewById<ImageView>(R.id.home_item_image_favorite)
    val itemNumOfFavorite = itemView.findViewById<TextView>(R.id.home_item_text_num_of_favorites)

    val context = context
    fun bindView(item : GetItemResult) {
        Glide.with(context).load(item.productImgUrl).into(imageUrl)
        //imageUrl.setImageResource(R.drawable.home_banner1)
        //"https://www.juso.go.kr/img/content/know_addr_1.png"
        itemName.text = item.productName
        itemPrice.text = parseToMoney(item.price.toString())
        itemFavorite.setImageResource(R.drawable.global_my_heart_default)
        if(item.isPick == 1){
            itemFavorite.setImageResource(R.drawable.global_my_heart_selected)

        }
        else{
            itemFavorite.setImageResource(R.drawable.global_my_heart_default)
        }


        itemNumOfFavorite.text = item.pickCount.toString()






    }

     fun parseToMoney(str: String): String {
        var len = str.length
        var arr = str.toCharArray()
        var sb = StringBuilder()
        var before = str
        var cur = str
        if(len > 0) {
            var cnt = 1
            var idx = len-1
            while(cnt <= len){
                sb.append(arr[idx])
                if(cnt%3 == 0 ) {
                    if(cnt != len) {
                        sb.append(',')
                    }
                }
                cnt+=1
                idx-=1

            }
        }
        return sb.reverse().toString()
    }
}