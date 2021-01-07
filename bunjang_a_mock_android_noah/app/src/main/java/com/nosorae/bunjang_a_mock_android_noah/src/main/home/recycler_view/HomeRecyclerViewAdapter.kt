package com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeFragmentView
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeService
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.collection_dialog.CollectionDialog
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.*

class HomeRecyclerViewAdapter(private val context: Context?, var itemList: ArrayList<GetItemResult>)
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
        val container = holder.itemView.findViewById<ImageView>(R.id.home_item_image_favorite)
        container.setOnClickListener {
            HomeService(this).tryGetCollection()
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
    }

    override fun onFavoriteFailure(message: String) {
        TODO("Not yet implemented")
    }
}