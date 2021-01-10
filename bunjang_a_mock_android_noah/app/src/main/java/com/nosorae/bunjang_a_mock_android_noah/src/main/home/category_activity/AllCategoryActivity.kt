package com.nosorae.bunjang_a_mock_android_noah.src.main.home.category_activity


import android.content.Intent
import android.os.Bundle
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityAllCategoryBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.OneCategoryActivity

class AllCategoryActivity :
    BaseActivity<ActivityAllCategoryBinding>(ActivityAllCategoryBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //1: 여성의류, 2: 남성의류, 3: 패션잡화, 4: 뷰티/미용, 5: 유아동/출산, 6: 스포츠/레저
        binding.categoryWoman.setOnClickListener {
            val intent = Intent(this, OneCategoryActivity::class.java)
            intent.putExtra("categoryNum", 1)
            startActivity(intent)
            finish()
        }
        binding.categoryMan.setOnClickListener {
            val intent = Intent(this, OneCategoryActivity::class.java)
            intent.putExtra("categoryNum", 2)
            startActivity(intent)
            finish()
        }
        binding.categoryFashion.setOnClickListener {
            val intent = Intent(this, OneCategoryActivity::class.java)
            intent.putExtra("categoryNum", 3)
            startActivity(intent)
            finish()
        }
        binding.categoryBeauty.setOnClickListener {
            val intent = Intent(this, OneCategoryActivity::class.java)
            intent.putExtra("categoryNum", 4)
            startActivity(intent)
            finish()
        }
        binding.categoryBaby.setOnClickListener {
            val intent = Intent(this, OneCategoryActivity::class.java)
            intent.putExtra("categoryNum", 5)
            startActivity(intent)
            finish()
        }
        binding.categorySports.setOnClickListener {
            val intent = Intent(this, OneCategoryActivity::class.java)
            intent.putExtra("categoryNum", 6)
            startActivity(intent)
            finish()
        }


    }
}