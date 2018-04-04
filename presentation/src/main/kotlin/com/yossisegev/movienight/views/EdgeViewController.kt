package com.yossisegev.movienight.views

import android.content.Context
import android.graphics.PixelFormat
import android.os.Build
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.Gravity
import android.view.WindowManager
import android.widget.ImageView
import com.yossisegev.movienight.common.Settings

/**
 * Created by hanhanh.nguyen on 4/2/2018.
 */
class EdgeViewController(var context: Context) {
    lateinit var windowManager : WindowManager
    lateinit var edgeParams : WindowManager.LayoutParams
    lateinit var settings : Settings
    var isShow = false
    var edgeView: Any? = null

    var screenWidth : Int = 0
    var screenHeight : Int = 0

    init {

    }

    fun removeEdgeView(){
        windowManager.removeView(edgeView as EdgeView)
        isShow = false
    }

    fun showEdgeView(){
        setupLayoutParams()
        calculateForDevice()
        showEdge()
    }

    fun setupLayoutParams(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            edgeParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        } else {
            edgeParams.type = WindowManager.LayoutParams.TYPE_PRIORITY_PHONE
        }
        edgeParams.format = PixelFormat.RGBA_8888
        edgeParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
        edgeParams.gravity = Gravity.RIGHT
        edgeParams.x = 0
        edgeParams.y = 0
        edgeParams.width = WindowManager.LayoutParams.WRAP_CONTENT
        edgeParams.height = WindowManager.LayoutParams.WRAP_CONTENT
    }

    fun calculateForDevice(){
        val dm = DisplayMetrics()
        windowManager.getDefaultDisplay().getMetrics(dm)
        screenWidth = dm.widthPixels
        screenHeight = dm.heightPixels
    }

    fun showEdge(){
        edgeView ?: createEdgeView()
        windowManager.addView(edgeView as EdgeView, edgeParams)
        isShow = true
    }

    fun createEdgeView(){
        edgeView = EdgeView(context)
        val id = settings.getEdgeViewIcon()
        val img = (edgeView as EdgeView).setIcon(id)
        val size = settings.getEdgeViewSize()
        setEdgeViewSize(context, img, size)
        val alpha = settings.getEdgeViewAlpha()
        img.setAlpha(alpha)
    }

    fun isShowEdgeView() : Boolean{
        return isShow
    }

    fun setEdgeViewSize(context: Context, img: ImageView, size: Int){
        var params = img.layoutParams
        var dpSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, size as Float, context.resources.displayMetrics) as Int
    }
}