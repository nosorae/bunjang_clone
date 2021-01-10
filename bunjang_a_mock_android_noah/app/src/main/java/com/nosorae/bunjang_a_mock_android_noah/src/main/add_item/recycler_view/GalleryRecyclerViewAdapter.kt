package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.recycler_view

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R

class GalleryRecyclerViewAdapter(private val context: Context?, val itemList: ArrayList<GalleryRecyclerViewItem>,
                                 val isInList: ArrayList<String>)
    : RecyclerView.Adapter<GalleryRecyclerViewViewHolder>() {

    var cnt = 1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryRecyclerViewViewHolder {
        return GalleryRecyclerViewViewHolder(context!!,
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_gallery, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: GalleryRecyclerViewViewHolder, position: Int) {
        val image = holder.itemView.findViewById<ImageView>(R.id.recycler_view_item_gallery_image)
        val num = holder.itemView.findViewById<TextView>(R.id.recycler_view_item_gallery_text_num)
        image.setOnClickListener {
            if(num.visibility == View.INVISIBLE) {
                image.foreground = ContextCompat.getDrawable(context!!, R.drawable.add_item_gallery_item_background)
                num.text = cnt.toString()
                cnt+=1
                num.visibility = View.VISIBLE
                isInList.add(itemList[position].imageUri)
            }
            else if(num.visibility == View.VISIBLE) {
                image.foreground = ContextCompat.getDrawable(context!!, R.drawable.add_item_gallery_item_background_cancel)
                num.visibility = View.INVISIBLE
                cnt-=1
                isInList.remove(itemList[position].imageUri)
                notifyDataSetChanged()
                //isInList.remove(itemList[position])
            }
        }
        if(!isInList.contains(itemList[position].imageUri)){
            image.foreground = ContextCompat.getDrawable(context!!, R.drawable.add_item_gallery_item_background_cancel)
            num.visibility = View.INVISIBLE
        }
        if(isInList.contains(itemList[position].imageUri)) {
            image.foreground = ContextCompat.getDrawable(context!!, R.drawable.add_item_gallery_item_background)
            num.text = (isInList.indexOf(itemList[position].imageUri)+1).toString()
            num.visibility = View.VISIBLE
        }
        holder.bindView(itemList[position])
    }

}