package com.example.chatapp

import android.app.Application
import com.google.firebase.FirebaseApp


class ChatApp : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}

