package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.gallery_warning_dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.Window
import android.widget.TextView
import com.nosorae.bunjang_a_mock_android_noah.R


class GalleryWarningDialog(context : Context) : Dialog(context)  {

    fun showLogInDialog(myContent: String,  myYes: String){

        requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        setContentView(R.layout.dialog_global_just_ok)

        val window: Window? = getWindow()
        if (window != null) {
            // 백그라운드 투명
            window.setBackgroundDrawable(ColorDrawable(Color.WHITE))
            //val params: WindowManager.LayoutParams = window.getAttributes()
            // 화면에 가득 차도록
            //params.width = WindowManager.LayoutParams.MATCH_PARENT
            // params.height = WindowManager.LayoutParams.MATCH_PARENT

            // 열기&닫기 시 애니메이션 설정
            // params.windowAnimations = R.style.AnimationPopupStyle
            // window.setAttributes(params)
            // UI 중앙정렬
            window.setGravity(Gravity.CENTER)
        }



        val content = findViewById<TextView>(R.id.global_dialog_ok_content)
        val yes = findViewById<TextView>(R.id.global_dialog_ok_ok)

        content.text = myContent

        yes.text= myYes


        yes.setOnClickListener {
            dismiss()
        }



        show()
    }

}