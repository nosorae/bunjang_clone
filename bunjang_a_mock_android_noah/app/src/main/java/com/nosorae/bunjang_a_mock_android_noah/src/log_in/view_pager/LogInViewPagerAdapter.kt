package com.nosorae.bunjang_a_mock_android_noah.src.log_in

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R

class LogInViewPagerAdapter(private val context: Context,
                            private var pageList: ArrayList<LogInViewPagerItem>)
    : RecyclerView.Adapter<LogInViewPagerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogInViewPagerViewHolder {
        return LogInViewPagerViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.view_pager_log_in, parent, false))
    }

    override fun getItemCount(): Int {
        return pageList.size
    }

    override fun onBindViewHolder(holder: LogInViewPagerViewHolder, position: Int) {
        holder.bindView(pageList[position])
    }
}