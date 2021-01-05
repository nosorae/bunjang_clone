package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityAddItemGalleryBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.AddItemActivity
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.recycler_view.GalleryRecyclerViewAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.recycler_view.GalleryRecyclerViewItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.recycler_view.GalleryRecyclerViewSpacing


class AddItemGalleryActivity : BaseActivity<ActivityAddItemGalleryBinding>(ActivityAddItemGalleryBinding::inflate) {

    private var recyclerItemList = ArrayList<GalleryRecyclerViewItem>()
    private lateinit var recyclerAdapter : GalleryRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.imageViewButtonBack.setOnClickListener {
            finish()
        }
        binding.imageViewButtonCheck.setOnClickListener {
            startActivity(Intent(this, AddItemActivity::class.java))
        }

        parseAllImages()

    }


    private fun parseAllImages() {
        try {
            val projection =
                arrayOf(MediaStore.Images.Media.DATA)
            val cursor = contentResolver.query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                projection,  // Which columns to return
                null,  // Return all rows
                null,
                null
            )
            val size: Int = cursor!!.getCount()
            /*******  If size is 0, there are no images on the SD Card.  */
            if (size == 0) {
            } else {
                val thumbID = 0
                while (cursor.moveToNext()) {
                    val file_ColumnIndex: Int =
                        cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                    /**************** Captured image details  */
                    /*****  Used to show image on view in LoadImagesFromSDCard class  */
                    val path: String = cursor.getString(file_ColumnIndex)

                 recyclerItemList.add(GalleryRecyclerViewItem(path))
                }
                for(item in recyclerItemList){
                    Log.d("e??", "하이 : ${item.imageUri}")
                }
                recyclerAdapter = GalleryRecyclerViewAdapter(this, recyclerItemList)
                binding.galleryRecyclerView.apply {
                    adapter = recyclerAdapter
                    layoutManager = GridLayoutManager(context, 3)
                    addItemDecoration(GalleryRecyclerViewSpacing(16, 16))
                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}