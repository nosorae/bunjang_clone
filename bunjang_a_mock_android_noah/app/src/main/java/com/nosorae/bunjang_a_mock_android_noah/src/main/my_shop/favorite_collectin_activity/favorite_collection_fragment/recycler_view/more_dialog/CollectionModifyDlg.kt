package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.recycler_view.more_dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.FavoriteCollectionFragmentView
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.FavoriteCollectionService
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.add_collection_dialog.AddCollectionDialog


class CollectionModifyDlg(context : Context,
                                     val forCallBack: FavoriteCollectionFragmentView,
                                     val collectionId: Int,
                                     val collectionTitle: String) : Dialog(context)  {

    fun showLogInDialog(){

        requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        setContentView(R.layout.dialog_favorite_collection_modify)

        val window: Window? = getWindow()
        if (window != null) {
            // 백그라운드 투명
            window.setBackgroundDrawable(ColorDrawable(Color.WHITE))
            val params: WindowManager.LayoutParams = window.getAttributes()
            // 화면에 가득 차도록
            params.width = WindowManager.LayoutParams.MATCH_PARENT
            // params.height = WindowManager.LayoutParams.MATCH_PARENT

            // 열기&닫기 시 애니메이션 설정
            // params.windowAnimations = R.style.AnimationPopupStyle
            window.setAttributes(params)
            // UI 하단 정렬
            window.setGravity(Gravity.BOTTOM)
        }



        val closeButton = findViewById<ImageView>(R.id.dialog_modify_collection_button_close)
        val changeNameButton = findViewById<LinearLayout>(R.id.dialog_modify_collection_change_name)
        val deleteButton = findViewById<LinearLayout>(R.id.dialog_modify_collection_delete)

        closeButton.setOnClickListener {

            dismiss()
        }

        changeNameButton.setOnClickListener {
            AddCollectionDialog(context, forCallBack, 1, collectionId, collectionTitle).showLogInDialog()
            dismiss()
        }

        deleteButton.setOnClickListener {
            ReallyDeleteDialog(context, forCallBack, collectionId).showLogInDialog("컬렉션 삭제",
            "컬렉션 내의 상품도 함께 삭제됩니다. 정말\n 삭제하시겠습니까?", "취소", "컬렉션 삭제")

            dismiss()
        }






        show()
    }

}