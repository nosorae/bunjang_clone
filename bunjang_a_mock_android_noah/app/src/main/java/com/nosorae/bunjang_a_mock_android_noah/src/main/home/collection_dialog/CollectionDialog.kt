package com.nosorae.bunjang_a_mock_android_noah.src.main.home.collection_dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResult
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.Result
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view.HomeRecyclerViewAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.view_pager.HomeViewPagerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.view_pager.HomeViewPagerItem

class CollectionDialog(context : Context) : Dialog(context)  {



    private var recyclerItemList = ArrayList<Result>()
    private lateinit var recyclerAdapter : CollectionRecyclerViewAdapter


    fun showCollectionDialog(result: ArrayList<Result>) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        setContentView(R.layout.dialog_home_favorite_collections)

        val window: Window? = getWindow()
        if (window != null) {
            // 백그라운드 투명
            window.setBackgroundDrawable(ColorDrawable(Color.WHITE))
            val params: WindowManager.LayoutParams = window.getAttributes()
            // 화면에 가득 차도록
            params.width = WindowManager.LayoutParams.MATCH_PARENT
            // params.height = WindowManager.LayoutParams.MATCH_PARENT

            // 열기&닫기 시 애니메이션 설정
            //params.windowAnimations = R.style.AnimationPopupStyle
            window.setAttributes(params)
            // UI 하단 정렬
            window.setGravity(Gravity.BOTTOM)
        }


        //리스트 받아오는 코드드
       recyclerItemList = result


        recyclerAdapter= CollectionRecyclerViewAdapter(context, recyclerItemList)
        val closeButton = findViewById<ImageView>(R.id.dialog_home_favorite_collection_button_back)
        val recyclerView = findViewById<RecyclerView>(R.id.dialog_home_favorite_collection_recycler_view)
        recyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(context)


        }

        closeButton.setOnClickListener {
            dismiss()
        }
        show()
    }

}