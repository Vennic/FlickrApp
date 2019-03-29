package com.kuzheevadel.daggerrxapp.photolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.kuzheevadel.daggerrxapp.dagger.App
import com.kuzheevadel.daggerrxapp.R
import com.kuzheevadel.daggerrxapp.common.Photo
import com.kuzheevadel.daggerrxapp.interfaces.ListActivityInterface
import com.kuzheevadel.daggerrxapp.interfaces.ListPresenterInterface
import kotlinx.android.synthetic.main.flickr_list_activity.*
import javax.inject.Inject


class FlickrListActivity : AppCompatActivity(), ListActivityInterface {

    @Inject
    lateinit var mAdapter: RwAdapter

    @Inject
    lateinit var mPresenter: ListPresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flickr_list_activity)
        App.instance.createFlickrListComponent(this)?.inject(this)

        flickr_list_rw.layoutManager = LinearLayoutManager(this)
        flickr_list_rw.adapter = mAdapter
        mPresenter.downloadPhotos()
    }

    override fun onDestroy() {
        super.onDestroy()
        App.instance.releaseFlickrListComponent()
    }

    override fun updateAdapter(photoList: List<Photo>) {
        mAdapter.listItems = photoList
        mAdapter.notifyDataSetChanged()
    }
}
