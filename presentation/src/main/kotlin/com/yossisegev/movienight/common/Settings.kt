package com.yossisegev.movienight.common

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.yossisegev.movienight.R

/**
 * Created by hanhanh.nguyen on 4/3/2018.
 */
class Settings(var context: Context) {
    companion object {
        val EDGE_VIEW_ICON = "edge_view_icon"
        val EDGE_VIEW_SIZE = "edge_view_size"
        val EDGE_VIEW_ALPHA = "edge_view_alpha"
    }
    var prefs : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun getEdgeViewIcon() : Int{
        return prefs.getInt(EDGE_VIEW_ICON, R.drawable.ic_backspace_black_24dp)
    }

    fun getEdgeViewSize() : Int{
        return prefs.getInt(EDGE_VIEW_SIZE, 0)
    }

    fun getEdgeViewAlpha(): Int{
        return prefs.getInt(EDGE_VIEW_ALPHA, 0)
    }
}