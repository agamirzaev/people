package com.example.peoplelist

import android.app.Application
import com.example.peoplelist.data.DataManager

class App: Application() {
    var dataManager: DataManager? = null
    override fun onCreate() {
        super.onCreate()
        dataManager = DataManager()
    }
}