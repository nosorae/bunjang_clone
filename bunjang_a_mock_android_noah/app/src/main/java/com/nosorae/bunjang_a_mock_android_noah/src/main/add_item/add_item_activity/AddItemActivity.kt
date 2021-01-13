package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity


import android.app.Activity
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.TextView
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
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.UpdateItemRequest
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.UpdateItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.recycler_view.CandidateRecyclerItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.recycler_view.CandidateRecyclerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.recycler_view.CandidateRecyclerSpacing
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view.HomeRecyclerViewSpacing
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.ItemDetailActivityView
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.ItemDetailService
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.GetItemDetailResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.PostFollowResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.SellingFragmentView
import java.io.File
import java.lang.reflect.Type
import java.util.*


class AddItemActivity : BaseActivity<ActivityAddItemBinding>(ActivityAddItemBinding::inflate),
        AddItemActivityView,
        ItemDetailActivityView {
    lateinit var mStorageRef : StorageReference
    lateinit var storageRef: FirebaseStorage

    val initList: ArrayList<String>  = ArrayList<String>()

    private var recyclerItemList = ArrayList<String>()
    private lateinit var recyclerAdapter : CandidateRecyclerAdapter


    lateinit var imgList : Array<String>
    var includeDeliveryCharge = 'N'
    var isNegotiable = 'N'
    var category = 1
    var productState = 'U' // U중고상품 // N 새상품
    var isExchangeable = 'N' // Y N
    var amount = 1




    var productIdFromDialog = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        if (intent.getIntExtra("isUpdateFromDialog", 0) == 1) {
            productIdFromDialog = intent.getIntExtra("updateProductId", 1)
            if (productIdFromDialog != -1) {
                if (true) {
                    showLoadingDialog(this)
                    ItemDetailService(this).tryGetItemDetail(productIdFromDialog)
                }

            }
        } else {

            val tempList = getArrayList("isInList")

            if (tempList != null) {
                for (str in tempList) {
                    //initList.add(str)
                    recyclerItemList.add(str)
                }
            }

            recyclerAdapter = CandidateRecyclerAdapter(this, recyclerItemList, 0, this)
            binding.addItemRecyclerView.apply {
                adapter = recyclerAdapter
                val mana = LinearLayoutManager(context)

                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
                // addItemDecoration(CandidateRecyclerSpacing(12, 12))
            }

            binding.addItemNumOfPicture.text = recyclerItemList.size.toString()+" / 12"


        }





        binding.addItemButtonBack.setOnClickListener {
            finish()
        }

        val desc =  binding.addItemEditTextDescription
        val price = binding.addItemEditTextPrice

        desc.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
              if(!desc.text.toString().equals("") && !price.text.toString().equals("")){
                  binding.addItemComplete.setBackgroundColor(Color.RED)
              }

            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        price.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(!desc.text.toString().equals("") && !price.text.toString().equals("")){
                    binding.addItemComplete.setBackgroundColor(Color.RED)
                }


            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })










        mStorageRef = FirebaseStorage.getInstance().getReference()

        if (intent.getIntExtra("isUpdateFromDialog", 0) != 1) {
            binding.addItemComplete.setOnClickListener {
                // 상품 등록

                if (recyclerItemList != null) {
                    imgList = Array<String>(recyclerItemList.size, { "" })
                    var n = 0
                    for (path in recyclerItemList) {
                        val imgPathArr = path.split("/")
                        val file = Uri.fromFile(File(path))
                        val riversRef: StorageReference = mStorageRef!!.child("images/" + imgPathArr.last())
                        val ans = "https://firebasestorage.googleapis.com/v0/b/bunjang-noah.appspot.com/o/images%2F" + imgPathArr.last() + "?alt=media&token=685f970e-75d5-48eb-9754-6e261be94c7b"
                        imgList[n] = ans
                        n += 1
                        riversRef.putFile(file)
                                .addOnSuccessListener { taskSnapshot -> // Get a URL to the uploaded content
                                    val downloadUrl: String = taskSnapshot.uploadSessionUri.toString()
                                    Log.d("taskSnapshop", "이거시 url인가??" + downloadUrl)


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
                if (!priceStr.equals("")) {
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
                showLoadingDialog(this)
                AddItemService(this).tryPostAddItem(item)


            }

        }
    }







    override fun onPostAddItemSuccess(response: AddItemResponse) {

        Log.d("additem", "올렸음"+response.isSuccess+"  "+ response.message)
        dismissLoadingDialog()
        finish()
    }

    override fun onPostAddItemFailure(message: String) {
        Log.d("additem", "못올림" +message)
        dismissLoadingDialog()
        finish()
    }

    override fun onPutUpdateItemSuccess(response: UpdateItemResponse) {
        Log.d("Imgnum", "imgList 사진 갯수 : "+imgList.size.toString())
        dismissLoadingDialog()
        finish()
    }

    override fun onPutUpdateItemFailure(message: String) {
        Log.d("Imgnum", "imgList 사진 갯수 근데 업데이트 실패: "+imgList.size.toString())
        dismissLoadingDialog()
        finish()
    }




    fun getArrayList(key: String?): java.util.ArrayList<String>? {
            val prefs = getSharedPreferences("myPreference", Activity.MODE_PRIVATE)
            val gson = Gson()
            val json = prefs.getString(key, null)
            val type: Type = object : TypeToken<ArrayList<String?>?>() {}.getType()
            return gson.fromJson(json, type)
        }






    //----------------------------ItemDetailView-----------
    override fun onGetItemDetailSignUpSuccess(response: GetItemDetailResponse) {
        dismissLoadingDialog()
        val result = response.result
        val info = response.result.info
        binding.addItemEditTextName.setText(info.productName)
        binding.addItemEditTextDescription.setText(info.explanation)
        if(info.price != null){
            binding.addItemEditTextPrice.setText(info.price.toString(), TextView.BufferType.EDITABLE)
        }
        if(info.area != null) {
            binding.addItemEditTextLocation.setText(info.area.toString(), TextView.BufferType.EDITABLE)
        }



        //업데이트용 리사이클러뷰
        val temp = response.result.productImg
        Log.d("Imgnum", "temp 사진 갯수 : "+temp.size.toString() )
        recyclerItemList = ArrayList<String>()
        for(obj in temp) {
            recyclerItemList.add(obj.imgUrl)
        }
        recyclerAdapter = CandidateRecyclerAdapter(this, recyclerItemList, 1, this)
        binding.addItemRecyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            // addItemDecoration(CandidateRecyclerSpacing(12, 12))
        }

        binding.addItemNumOfPicture.text = recyclerItemList.size.toString()+" / 12"

        Log.d("Imgnum", "recycler 사진 갯수 : "+recyclerItemList.size.toString() )




        binding.addItemComplete.setOnClickListener {
            //여기서 업데이트
            /**
            if (recyclerItemList != null) {
                imgList = Array<String>(recyclerItemList.size, { "" })
                var n = 0
                for (path in recyclerItemList) {
                    val imgPathArr = path.split("/")
                    val file = Uri.fromFile(File(path))
                    val riversRef: StorageReference = mStorageRef!!.child("images/" + imgPathArr.last())
                    val ans = "https://firebasestorage.googleapis.com/v0/b/bunjang-noah.appspot.com/o/images%2F" + imgPathArr.last() + "?alt=media&token=685f970e-75d5-48eb-9754-6e261be94c7b"
                    imgList[n] = ans
                    n += 1
                    riversRef.putFile(file)
                            .addOnSuccessListener { taskSnapshot -> // Get a URL to the uploaded content
                                val downloadUrl: String = taskSnapshot.uploadSessionUri.toString()
                                Log.d("taskSnapshop", "이거시 url인가??" + downloadUrl)


                            }
                            .addOnFailureListener {
                                // Handle unsuccessful uploads
                                // ...
                            }
                }
            }
**/

                imgList = Array<String>(recyclerItemList.size, { "" })
                var i = 0
                 while(i <recyclerItemList.size) {
                     imgList[i] = recyclerItemList[i]
                     i+=1
                 }
            Log.d("Imgnum", "imgList 사진 갯수 : "+imgList.size.toString())
                productIdFromDialog = intent.getIntExtra("updateProductId", 1)
                val name = binding.addItemEditTextName.text.toString()
                val explanation = binding.addItemEditTextDescription.text.toString()
                val priceStr = binding.addItemEditTextPrice.text.toString()
                var price = 0
                if (!priceStr.equals("")) {
                    price = priceStr.toInt()
                }

                val area = binding.addItemEditTextLocation.text.toString()

                val item = UpdateItemRequest(
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
                showLoadingDialog(this)
            Log.d("Imgnum", "imgList 사진 갯수 : "+imgList.size.toString())
                AddItemService(this).tryPutUpdateItem(productIdFromDialog, item)


        }

    }

    override fun onGetItemDetailSignUpFailure(message: String) {
        dismissLoadingDialog()
    }

    override fun onPostFollowSuccess(response: PostFollowResponse) {

    }

    override fun onPostFollowFailure(message: String) {

    }

    override fun onClickDeleteButton() {
        binding.addItemNumOfPicture.text = recyclerItemList.size.toString()+" / 12"
    }
}