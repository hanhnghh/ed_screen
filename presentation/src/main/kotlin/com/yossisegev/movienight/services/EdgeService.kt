package com.yossisegev.movienight.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.yossisegev.movienight.views.EdgeView
import com.yossisegev.movienight.views.EdgeViewController
import javax.inject.Inject

/**
 * Created by hanhanh.nguyen on 3/29/2018.
 */
class EdgeService : Service() {

    @Inject
    lateinit var edgeViewController: EdgeViewController

    companion object {
        val SERVICE_CONNECTED = "service_connected"
        val SERVICE_DISCONNECTED = "service_disconnected"
    }

    override fun onBind(p0: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun isServiceEnable(): Boolean{
        return edgeViewController.isShowEdgeView()
    }

    fun startService(){
        edgeViewController.showEdgeView()
    }

    fun stopService(){
        edgeViewController.removeEdgeView()
    }
}