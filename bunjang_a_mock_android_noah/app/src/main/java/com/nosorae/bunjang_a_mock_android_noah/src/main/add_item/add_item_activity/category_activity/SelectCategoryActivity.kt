package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.category_activity

import android.content.Intent
import android.os.Bundle
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivitySelectCategoryBinding

class SelectCategoryActivity : BaseActivity<ActivitySelectCategoryBinding>(ActivitySelectCategoryBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.selectCategoryButtonBack.setOnClickListener {
            finish()
        }

       binding.selectCategoryWoman.setOnClickListener {
           val intent = Intent()
           intent.putExtra("category", "여성의류")
           intent.putExtra("categoryNum", 1)//사용자에게 입력받은값 넣기
           setResult(RESULT_OK, intent)
           finish()

       }
        binding.selectCategoryMan.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", "남성의류")
            intent.putExtra("categoryNum", 2)//사용자에게 입력받은값 넣기
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.selectCategoryFashion.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", "패션잡화")
            intent.putExtra("categoryNum", 3)//사용자에게 입력받은값 넣기
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.selectCategoryBeauty.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", "뷰티/미용")
            intent.putExtra("categoryNum", 4)//사용자에게 입력받은값 넣기
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.selectCategoryBaby.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", "유아동/출산")
            intent.putExtra("categoryNum", 5)//사용자에게 입력받은값 넣기
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.selectCategorySports.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", "스포츠/레저")
            intent.putExtra("categoryNum", 6)//사용자에게 입력받은값 넣기
            setResult(RESULT_OK, intent)
            finish()
        }

    }
}