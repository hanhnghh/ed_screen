package com.yossisegev.movienight.services

import android.app.Activity
import android.content.*
import android.os.IBinder
import com.yossisegev.movienight.common.LocalBinder
import java.util.*

/**
 * Created by hanhanh.nguyen on 3/29/2018.
 */
class EdgeServiceConnectionUtils {

    companion object {
        var serviceBinder : LocalBinder? = null
        val connectionMap  : WeakHashMap<Context, ServiceBinder> = WeakHashMap()

        fun bindToService(context : Context, callback : ServiceConnection): ServiceToken?{
            var realActivity: Activity = (context as Activity).parent ?: context as Activity
            val contextWrapper = ContextWrapper(realActivity)
            contextWrapper.startService(Intent(contextWrapper, EdgeService::class.java))

            val binder = ServiceBinder(callback)
            if(contextWrapper.bindService(Intent().setClass(contextWrapper, EdgeService::class.java), binder, 0)){
                connectionMap.put(contextWrapper, binder)
                return ServiceToken(contextWrapper)
            }
            return null
        }

        fun unbindFromService(token: ServiceToken?){
            if(token == null)
                return
            val contextWrapper = token?.wrappedContext
            val binder = connectionMap.remove(contextWrapper)
            if(binder == null)
                return

            contextWrapper.unbindService(binder)
            if(connectionMap.isEmpty())
                serviceBinder = null
        }
    }


    class ServiceBinder(val callBack : ServiceConnection) : ServiceConnection{

        override fun onServiceConnected(className: ComponentName?, service: IBinder?) {
            serviceBinder = service as LocalBinder
            callBack?.onServiceConnected(className, service)
        }

        override fun onServiceDisconnected(className: ComponentName?) {
            callBack?.onServiceDisconnected(className)
            serviceBinder = null
        }
    }

    class ServiceToken(var wrappedContext : ContextWrapper) {

    }
}