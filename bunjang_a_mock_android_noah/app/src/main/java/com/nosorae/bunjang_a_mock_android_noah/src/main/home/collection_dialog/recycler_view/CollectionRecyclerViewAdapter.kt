package com.nosorae.bunjang_a_mock_android_noah.src.main.home.collection_dialog.recycler_view

import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeFragmentView
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeService
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.*
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view.CustomCallBack

class CollectionRecyclerViewAdapter(private val context: Context?, var itemList: ArrayList<Result>,
                                    val dlg: Dialog, val productId: Int, val customCallBack: CustomCallBack)
    : RecyclerView.Adapter<CollectionRecyclerViewViewHolder>(), HomeFragmentView {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionRecyclerViewViewHolder {
        return CollectionRecyclerViewViewHolder(context!!,
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_dialog_collections, parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: CollectionRecyclerViewViewHolder, position: Int) {
        var container = holder.itemView.findViewById<ConstraintLayout>(R.id.recycler_view_item_container)

        container.setOnClickListener {
            if(itemList.size != 0){
                Log.d("productId", "프로덕트 아이디 : ${productId}")
                HomeService(this).tryPostFavorite(productId ,PostFavoriteRequest(itemList[position].collectionId))
            } else {
                Log.d("productId", "프로덕트 아이디 : ${productId}")
                HomeService(this).tryPostFavorite(productId, PostFavoriteRequest(null))
            }
        }
        holder.bindView(itemList[position])
    }


    override fun onGetItemSuccess(response: GetItemResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetItemFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onGetCollectionSuccess(response: GetCollectionResponse) {
        Log.d("favorite", "컬렉션 가져오기 성공 : "+response.message)
       // itemList = response.result as ArrayList<Result>
        //notifyDataSetChanged()

    }

    override fun onGetCollectionFailure(message: String) {
        Log.d("favorite", "컬렉션 가져오기 실패 : "+message)
    }

    override fun onPostFavoriteSuccess(response: PostFavoriteResponse) {
        Log.d("favorite", "찜 성공 : "+response.message)

        customCallBack.onFavoriteSuccess()


        //HomeService(this).tryGetCollection()


        dlg.dismiss()

        //notifyDataSetChanged()


    }

    override fun onPostFavoriteFailure(message: String) {
        Log.d("favorite", "찜 실패 : "+message)

    }
}