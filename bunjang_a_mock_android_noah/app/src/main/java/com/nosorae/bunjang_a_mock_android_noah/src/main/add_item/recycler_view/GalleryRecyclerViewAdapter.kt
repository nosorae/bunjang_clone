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
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.ForClickPicCallBack
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.gallery_warning_dialog.GalleryWarningDialog

class GalleryRecyclerViewAdapter(private val context: Context?, val itemList: ArrayList<GalleryRecyclerViewItem>,
                                 val isInList: ArrayList<String>, val forCallBack: ForClickPicCallBack)
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
                    if(isInList.size >= 12) {
                        GalleryWarningDialog(context!!).showLogInDialog("선택 가능한 사진 개수를 초과했습니다.", "확인")
                    } else {
                        image.foreground = ContextCompat.getDrawable(context!!, R.drawable.add_item_gallery_item_background)
                        num.text = cnt.toString()
                        cnt+=1
                        num.visibility = View.VISIBLE
                        isInList.add(itemList[position].imageUri)
                    }

                }
                else if(num.visibility == View.VISIBLE) {
                    image.foreground = ContextCompat.getDrawable(context!!, R.drawable.add_item_gallery_item_background_cancel)
                    num.visibility = View.INVISIBLE
                    cnt-=1
                    isInList.remove(itemList[position].imageUri)
                    notifyDataSetChanged()
                    //isInList.remove(itemList[position])
                }
                forCallBack.onClickPicture()



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