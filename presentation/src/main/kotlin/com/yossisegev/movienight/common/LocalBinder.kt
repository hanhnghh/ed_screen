package com.yossisegev.movienight.common

import android.os.Binder
import java.lang.ref.WeakReference

/**
 * Created by hanhanh.nguyen on 3/29/2018.
 */
class LocalBinder(edgeService: EdgeService) : Binder() {
    private var weakReference = WeakReference<EdgeService>(edgeService)

    fun getService() : EdgeService?{
        return weakReference.get()
    }
}