package com.kuzheevadel.daggerrxapp.photolist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.kuzheevadel.daggerrxapp.R
import com.kuzheevadel.daggerrxapp.common.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.rv_list_item.view.*

class RwAdapter(var listItems: List<Photo>,private var context: Context): RecyclerView.Adapter<RwAdapter.RwViewHolder>() {

    private val mPicasso = Picasso.get()

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): RwViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.rv_list_item, viewGroup, false)
        return RwViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(viewHolder: RwViewHolder, p1: Int) {
        mPicasso.load(listItems[p1].url_c)
            .into(viewHolder.imageView)
    }

    inner class RwViewHolder(item: View): RecyclerView.ViewHolder(item) {

        val imageView: ImageView = item.photo_image_view

    }

}

