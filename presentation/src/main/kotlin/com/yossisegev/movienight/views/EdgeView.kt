package com.yossisegev.movienight.views

import android.content.Context
import android.widget.ImageView
import android.widget.LinearLayout

/**
 * Created by hanhanh.nguyen on 4/3/2018.
 */

class EdgeView(var mContext : Context) : LinearLayout(mContext){
    lateinit var edgeIcon : ImageView

    fun setIcon(id : Int): ImageView{
        edgeIcon.setImageResource(id)
        return  edgeIcon
    }
}