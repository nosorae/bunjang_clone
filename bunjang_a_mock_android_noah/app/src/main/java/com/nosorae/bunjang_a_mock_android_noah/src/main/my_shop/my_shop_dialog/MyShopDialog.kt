package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.my_shop_dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import com.nosorae.bunjang_a_mock_android_noah.R


class MyShopDialog(context : Context) : Dialog(context)  {

    fun showLogInDialog(){

        requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        setContentView(R.layout.dialog_my_shop)

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



        val closeButton = findViewById<ImageView>(R.id.dialog_my_shop_button_back)

        closeButton.setOnClickListener {
            dismiss()
        }
        show()
    }

}