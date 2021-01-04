package com.nosorae.bunjang_a_mock_android_noah.src.main.home.view_pager


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R

class HomeViewPagerAdapter(private var pageList: ArrayList<HomeViewPagerItem>)
    : RecyclerView.Adapter<HomeViewPagerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewPagerViewHolder {
        return HomeViewPagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item_home, parent, false))
    }

    override fun getItemCount(): Int {
        return pageList.size
    }

    override fun onBindViewHolder(holder: HomeViewPagerViewHolder, position: Int) {
        holder.bindView(pageList[position])
    }
}