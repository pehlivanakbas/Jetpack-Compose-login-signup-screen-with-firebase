package com.cc.cardscampaignscompose.ui.theme

import android.app.Application
import com.google.firebase.FirebaseApp

class CCAppApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}