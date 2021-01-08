package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.recycler_view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoriteItemRecyclerViewSpacing(var mSpacing: Int, var mTopSpacing: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        var index = (view.getLayoutParams() as GridLayoutManager.LayoutParams).spanIndex
        var position = parent.getChildLayoutPosition(view)
        if(index == 0){
            outRect.right = mSpacing/2
        }
        else {
            outRect.left = mSpacing/2
        }
        if(position < 2){
            outRect.top = 0
        }
        else{
            outRect.top = mTopSpacing
        }

    }
}