package com.kuzheevadel.daggerrxapp.photolist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.kuzheevadel.daggerrxapp.R
import kotlinx.android.synthetic.main.rv_list_item.view.*

class RwAdapter(private var listItems: List<Int>,private var context: Context): RecyclerView.Adapter<RwAdapter.RwViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): RwViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.rv_list_item, viewGroup, false)
        return RwViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(viewHolder: RwViewHolder, p1: Int) {
        viewHolder.imageView.setImageResource(R.drawable.bill_up_close)
    }

    inner class RwViewHolder(item: View): RecyclerView.ViewHolder(item) {

        val imageView: ImageView = item.photo_image_view

    }

}

