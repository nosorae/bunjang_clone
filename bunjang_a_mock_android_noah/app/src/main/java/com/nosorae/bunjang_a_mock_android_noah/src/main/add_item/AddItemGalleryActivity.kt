package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityAddItemGalleryBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.AddItemActivity
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.recycler_view.GalleryRecyclerViewAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.recycler_view.GalleryRecyclerViewItem
import java.lang.reflect.Type


class AddItemGalleryActivity : BaseActivity<ActivityAddItemGalleryBinding>(ActivityAddItemGalleryBinding::inflate) {

    private var recyclerItemList = ArrayList<GalleryRecyclerViewItem>()
    private lateinit var recyclerAdapter : GalleryRecyclerViewAdapter
    private val isInList = ArrayList<String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showLoadingDialog(this)





        binding.addItemButtonBack.setOnClickListener {
            val intent = Intent(this, AddItemActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.imageViewButtonCheck.setOnClickListener {
            for(i in isInList){
                Log.d("isInList", "절대주소: "+i)
            }
            saveArrayList(isInList, "isInList")
            val intent = Intent(this, AddItemActivity::class.java)
            startActivity(intent)
            finish()
        }

        parseAllImages()

        dismissLoadingDialog()

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

            var tempList = ArrayList<GalleryRecyclerViewItem>()
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

                recyclerItemList.reverse()
                recyclerAdapter = GalleryRecyclerViewAdapter(this, recyclerItemList, isInList)
                binding.galleryRecyclerView.apply {
                    adapter = recyclerAdapter
                    layoutManager = GridLayoutManager(context, 3)
                    //addItemDecoration(GalleryRecyclerViewSpacing(4, 4))
                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    fun saveArrayList(list: java.util.ArrayList<String>?, key: String?) {
        val prefs = getSharedPreferences("myPreference", Activity.MODE_PRIVATE)
        val editor = prefs.edit()
        val gson = Gson()
        val json: String = gson.toJson(list)
        editor.putString(key, json)
        editor.apply() // This line is IMPORTANT !!!
    }

    fun getArrayList(key: String?): java.util.ArrayList<String>? {
        val prefs = getSharedPreferences("myPreference", Activity.MODE_PRIVATE)
        val gson = Gson()
        val json = prefs.getString(key, null)
        val type: Type = object : TypeToken<java.util.ArrayList<String?>?>() {}.getType()
        return gson.fromJson(json, type)
    }











}