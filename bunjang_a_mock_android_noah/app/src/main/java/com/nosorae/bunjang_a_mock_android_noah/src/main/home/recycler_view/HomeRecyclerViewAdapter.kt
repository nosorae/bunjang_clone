package com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.databinding.GlobalCustomToastBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeFragment
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeFragmentView
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeService
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.collection_dialog.CollectionDialog
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.*
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.ItemDetailActivity

class HomeRecyclerViewAdapter(private val context: Context?, var itemList: ArrayList<GetItemResult>, val forToast: HomeFragment)
    : RecyclerView.Adapter<HomeRecyclerViewViewHolder>(), HomeFragmentView, CustomCallBack {

    var pos = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewViewHolder {
        return HomeRecyclerViewViewHolder(context!!,
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_home, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: HomeRecyclerViewViewHolder, position: Int) {
        val favorite = holder.itemView.findViewById<ImageView>(R.id.home_item_image_favorite)
        val container = holder.itemView.findViewById<ConstraintLayout>(R.id.home_item_container)

        container.setOnClickListener {
            val intent = Intent(context, ItemDetailActivity::class.java)
            intent.putExtra("itemId", itemList[position].productId)
            context!!.startActivity(intent)
        }

        favorite.setOnClickListener {
            if(itemList[position].isPick == 0) {
                HomeService(this).tryGetCollection()
            } else {
                HomeService(this).tryPostFavorite(itemList[position].productId, PostFavoriteRequest(null))
            }

            pos = position
        }
        holder.bindView(itemList[position])
    }




    override fun onGetItemSuccess(response: GetItemResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetItemFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onPostFavoriteSuccess(response: PostFavoriteResponse) {
        Log.d("favorite", response.message)
        itemList[pos].isPick = 0
        notifyDataSetChanged()
        showCustomToast("찜 해제가 완료되었습니다", forToast.layoutInflater)

    }

    override fun onPostFavoriteFailure(message: String) {
        Log.d("favorite", message)
    }


    override fun onGetCollectionSuccess(response: GetCollectionResponse) {

        val result = response.result
       if(result.size != 0){
           val temp = ArrayList<Result>()
           temp.addAll(result)
           CollectionDialog(context!!, this).showCollectionDialog(temp, itemList[pos].productId)
       } else {
           val temp = ArrayList<Result>()
           CollectionDialog(context!!, this).showCollectionDialog(temp, itemList[pos].productId)
       }
    }

    override fun onGetCollectionFailure(message: String) {

    }

    override fun onFavoriteSuccess() {
        if(itemList[pos].isPick == 1) {
            itemList[pos].isPick = 0
        }else{
            itemList[pos].isPick = 1
        }
        notifyDataSetChanged()

        showCustomToast("찜 컬렉션에 추가 완료!", forToast.layoutInflater)



    }

    override fun onFavoriteFailure(message: String) {
        TODO("Not yet implemented")
    }

    fun showCustomToast(content: String, inflater: LayoutInflater) {
        val binding = GlobalCustomToastBinding.inflate(inflater)
        val text = binding.globalCustomToastText
        text.text = content
        val toast = Toast(context)
        toast.setGravity(Gravity.BOTTOM, 0, 0) // CENTER를 기준으로 0, 0 위치에 메시지 출력
        toast.setDuration(Toast.LENGTH_LONG)
        toast.setView(binding.globalCustomToastRoot)
        toast.show()
    }
}