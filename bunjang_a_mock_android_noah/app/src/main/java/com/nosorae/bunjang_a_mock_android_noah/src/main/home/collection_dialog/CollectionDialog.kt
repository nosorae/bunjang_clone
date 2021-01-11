package com.nosorae.bunjang_a_mock_android_noah.src.main.home.collection_dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.collection_dialog.recycler_view.CollectionRecyclerViewAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.*
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view.CustomCallBack
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.FavoriteCollectionFragmentView
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.FavoriteCollectionService
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.add_collection_dialog.AddCollectionDialog
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model.DeleteFavoriteCollectionResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model.GetFavoriteCollectionResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model.PatchFavoriteCollectionResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model.PostFavoriteCollectionResponse


class CollectionDialog(context : Context, var customCallBack: CustomCallBack) : Dialog(context),
        FavoriteCollectionFragmentView {



    private var recyclerItemList = ArrayList<Result>()
    private lateinit var recyclerAdapter : CollectionRecyclerViewAdapter


    fun showCollectionDialog(result: ArrayList<Result>, productId: Int) {
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




        val closeButton = findViewById<ImageView>(R.id.dialog_home_favorite_collection_button_back)
        val recyclerView = findViewById<RecyclerView>(R.id.dialog_home_favorite_collection_recycler_view)
        val addButton = findViewById<LinearLayout>(R.id.dialog_home_add_collection)
        recyclerAdapter= CollectionRecyclerViewAdapter(context, recyclerItemList, this, productId, customCallBack)
        recyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(context)
        }







        addButton.setOnClickListener {
            AddCollectionDialog(context, this, 0, 0, "").showLogInDialog()
        }


        closeButton.setOnClickListener {
            dismiss()
        }
        show()
    }


    override fun onGetCollectionSuccess(response: GetFavoriteCollectionResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetCollectionFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onPostCollectionSuccess(response: PostFavoriteCollectionResponse) {
        Log.d("onPostCollectionSuccess", response.message)
    }

    override fun onPostCollectionFailure(message: String) {

    }

    override fun onDeleteCollectionSuccess(response: DeleteFavoriteCollectionResponse) {
        TODO("Not yet implemented")
    }

    override fun onDeleteCollectionFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onPatchCollectionSuccess(response: PatchFavoriteCollectionResponse) {
        TODO("Not yet implemented")
    }

    override fun onPatchCollectionFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onAddCollectionDialog(name: String) {
        recyclerItemList.add(Result(1, name, null, 0))
        recyclerAdapter= CollectionRecyclerViewAdapter(context, recyclerItemList, this, 1, customCallBack)
        findViewById<RecyclerView>(R.id.dialog_home_favorite_collection_recycler_view).apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(context)
        }

        FavoriteCollectionService(this).tryPostCollection(name)


    }

    override fun onChangeCollectionDialog(name: String) {
        TODO("Not yet implemented")
    }
}