package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.recycler_view


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_item_activity.FavoriteCollectionItemActivity
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.FavoriteCollectionFragmentView
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model.*
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.recycler_view.more_dialog.CollectionModifyDlg

class FavoriteItemRecyclerViewAdapter(private val context: Context?, val itemList: ArrayList<GetFavoriteCollectionResult>)
    : RecyclerView.Adapter<FavoriteItemRecyclerHolder>(), FavoriteCollectionFragmentView {

    var pos = 0
    var temp = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteItemRecyclerHolder {
        return FavoriteItemRecyclerHolder(context!!,
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_activity_collections, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: FavoriteItemRecyclerHolder, position: Int) {
        val container = holder.itemView.findViewById<ConstraintLayout>(R.id.favorite_collection_container)
        val more = holder.itemView.findViewById<ImageView>(R.id.favorite_item_button_more)
        container.setOnClickListener {
            val intent = Intent(context, FavoriteCollectionItemActivity::class.java)
            intent.putExtra("title", itemList[position].collectionName)
            intent.putExtra("collectionId", itemList[position].collectionId)
            context!!.startActivity(intent)
        }
        more.setOnClickListener {
            CollectionModifyDlg(context!!, this, itemList[position].collectionId, itemList[position].collectionName).showLogInDialog()
            pos = position
        }
        holder.bindView(itemList[position])
    }


    override fun onGetCollectionSuccess(response: GetFavoriteCollectionResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetCollectionFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onPostCollectionSuccess(response: PostFavoriteCollectionResponse) {
        TODO("Not yet implemented")
    }

    override fun onPostCollectionFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onDeleteCollectionSuccess(response: DeleteFavoriteCollectionResponse) {
        itemList.removeAt(pos)
        notifyDataSetChanged()
    }

    override fun onDeleteCollectionFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onAddCollectionDialog(name: String) {
        TODO("Not yet implemented")
    }

    override fun onPatchCollectionSuccess(response: PatchFavoriteCollectionResponse) {
        TODO("Not yet implemented")
    }

    override fun onPatchCollectionFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onChangeCollectionDialog(name: String) {
        itemList[pos].collectionName = name
        notifyDataSetChanged()
    }
}