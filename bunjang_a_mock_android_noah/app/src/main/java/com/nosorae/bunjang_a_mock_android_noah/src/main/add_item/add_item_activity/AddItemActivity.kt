package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity


import android.os.Bundle
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityAddItemBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.AddItemResponse


class AddItemActivity : BaseActivity<ActivityAddItemBinding>(ActivityAddItemBinding::inflate), AddItemActivityView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


       binding.addItemComplete.setOnClickListener {
           val name = binding.addItemEditTextName.text.toString()
           val category = binding.addItemEditTextTag.text.toString().toInt()
           val explanation = binding.addItemEditTextDescription.text.toString()
           val price = binding.addItemEditTextPrice.text.toString().toInt()
           //AddItemService(this).tryPostAddItem()
       }





    }

    override fun onPostAddItemSuccess(response: AddItemResponse) {

    }

    override fun onPostAddItemFailure(message: String) {

    }
}