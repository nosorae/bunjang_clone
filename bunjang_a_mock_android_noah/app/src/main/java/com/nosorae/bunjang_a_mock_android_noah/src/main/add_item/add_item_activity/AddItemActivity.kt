package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity


import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityAddItemBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.AddItemRequest
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.AddItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.recycler_view.CandidateRecyclerItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.recycler_view.CandidateRecyclerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.recycler_view.CandidateRecyclerSpacing
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view.HomeRecyclerViewSpacing
import java.io.File
import java.lang.reflect.Type
import java.util.*


class AddItemActivity : BaseActivity<ActivityAddItemBinding>(ActivityAddItemBinding::inflate), AddItemActivityView{
    lateinit var mStorageRef : StorageReference
    lateinit var storageRef: FirebaseStorage
    lateinit var imgList : Array<String>
    val initList: ArrayList<String>  = ArrayList<String>()

    private var recyclerItemList = ArrayList<String>()
    private lateinit var recyclerAdapter : CandidateRecyclerAdapter

    var includeDeliveryCharge = 'N'
    var isNegotiable = 'N'
    var category = 1
    var productState = 'U' // U중고상품 // N 새상품
    var isExchangeable = 'N' // Y N
    var amount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempList = getArrayList("isInList")

        if(tempList != null){
            for(str in tempList){
                //initList.add(str)
                recyclerItemList.add(str)
            }
        }

        recyclerAdapter = CandidateRecyclerAdapter(this, recyclerItemList)
        binding.addItemRecyclerView.apply {
            adapter = recyclerAdapter
            val mana = LinearLayoutManager(context)

            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
           // addItemDecoration(CandidateRecyclerSpacing(12, 12))
        }





        binding.addItemButtonBack.setOnClickListener {
            finish()
        }










        mStorageRef = FirebaseStorage.getInstance().getReference()





                binding.addItemComplete.setOnClickListener {


                    if (recyclerItemList != null) {
                        imgList = Array<String>(recyclerItemList.size, {""})
                        var n = 0
                        for(path in recyclerItemList) {
                            val imgPathArr = path.split("/")
                            val file = Uri.fromFile(File(path))
                            val riversRef: StorageReference = mStorageRef!!.child("images/"+imgPathArr.last())
                            val ans = "https://firebasestorage.googleapis.com/v0/b/bunjang-noah.appspot.com/o/images%2F"+imgPathArr.last()+"?alt=media&token=685f970e-75d5-48eb-9754-6e261be94c7b"
                            imgList[n] = ans
                            n+=1
                            riversRef.putFile(file)
                                    .addOnSuccessListener { taskSnapshot -> // Get a URL to the uploaded content
                                        val downloadUrl: String = taskSnapshot.uploadSessionUri.toString()
                                        Log.d("taskSnapshop", "이거시 url인가??"+ downloadUrl)


                                    }
                                    .addOnFailureListener {
                                        // Handle unsuccessful uploads
                                        // ...
                                    }
                        }
                    }







                    val name = binding.addItemEditTextName.text.toString()

                    val explanation = binding.addItemEditTextDescription.text.toString()
                    val priceStr = binding.addItemEditTextPrice.text.toString()
                    var price = 0
                    if(!priceStr.equals("")){
                        price = priceStr.toInt()
                    }

                    val area = binding.addItemEditTextLocation.text.toString()
                    val item = AddItemRequest(
                            name,
                            category,
                            explanation,
                            price,
                            includeDeliveryCharge,
                            isNegotiable,
                            area,
                            amount,
                            productState,
                            isExchangeable,
                            imgList,
                            arrayOf("#최상급", "#최저가")
                    )
                    AddItemService(this).tryPostAddItem(item)

                    finish()
                }
        }







    override fun onPostAddItemSuccess(response: AddItemResponse) {

        Log.d("additem", "올렸음"+response.isSuccess+"  "+ response.message)

    }

    override fun onPostAddItemFailure(message: String) {
        Log.d("additem", "못올림" +message)
    }




        fun getArrayList(key: String?): java.util.ArrayList<String>? {
            val prefs = getSharedPreferences("myPreference", Activity.MODE_PRIVATE)
            val gson = Gson()
            val json = prefs.getString(key, null)
            val type: Type = object : TypeToken<ArrayList<String?>?>() {}.getType()
            return gson.fromJson(json, type)
        }



}