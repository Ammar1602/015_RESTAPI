package com.example.aplikasidatasiswa

import android.app.Application
import com.example.aplikasidatasiswa.repository.AppContainer
import com.example.aplikasidatasiswa.repository.KontakContainer

class KontakApplication : Application() {
    /* AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = KontakContainer( )
    }
}