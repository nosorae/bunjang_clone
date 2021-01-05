package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity


import android.os.Bundle
import android.util.Log
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityAddItemBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.AddItemRequest
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.AddItemResponse


class AddItemActivity : BaseActivity<ActivityAddItemBinding>(ActivityAddItemBinding::inflate), AddItemActivityView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


       binding.addItemComplete.setOnClickListener {
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
                   3,
                   explanation,
                   price,
                   'N',
                   'N',
                   area,
                   1,
                   'U',
                   'N',
                   arrayOf("https://image.auction.co.kr/itemimage/18/63/e0/1863e07406.jpg"),
                   arrayOf("#비눗방울", "#쥬쥬", "#미개봉중고")
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
}