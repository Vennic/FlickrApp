package com.kuzheevadel.daggerrxapp.photolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.kuzheevadel.daggerrxapp.dagger.App
import com.kuzheevadel.daggerrxapp.R
import kotlinx.android.synthetic.main.flickr_list_activity.*
import javax.inject.Inject


class FlickrListActivity : AppCompatActivity() {

    @Inject
    lateinit var adapter: RwAdapter

    @Inject
    lateinit var presenter: FlickrListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flickr_list_activity)
        App.instance.createFlickrListComponent(this)?.inject(this)

        flickr_list_rw.layoutManager = LinearLayoutManager(this)
        flickr_list_rw.adapter = adapter

    }

    override fun onDestroy() {
        super.onDestroy()
        App.instance.releaseFlickrListComponent()
    }
}
