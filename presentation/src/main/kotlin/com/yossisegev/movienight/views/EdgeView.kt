package com.yossisegev.movienight.views

import android.content.Context
import android.graphics.PixelFormat
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * Created by hanhanh.nguyen on 4/2/2018.
 */
class EdgeView(var context: Context) {
    lateinit var windowManager : WindowManager
    lateinit var edgeParams : WindowManager.LayoutParams
    var screenWidth : Int = 0
    var screenHeight : Int = 0

    init {

    }

    public fun showEdgeView(){
        setupLayoutParams()
        calculateForDevice()
        showEdge()
    }

    fun setupLayoutParams(){

    }

    fun calculateForDevice(){
        val dm = DisplayMetrics()
        windowManager.getDefaultDisplay().getMetrics(dm)
        screenWidth = dm.widthPixels
        screenHeight = dm.heightPixels
    }

    fun showEdge(){
        edgeParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        edgeParams.format = PixelFormat.RGBA_8888
        edgeParams.flags = LayoutParams.FLAG_NOT_TOUCH_MODAL | LayoutParams.FLAG_NOT_FOCUSABLE
    }
}