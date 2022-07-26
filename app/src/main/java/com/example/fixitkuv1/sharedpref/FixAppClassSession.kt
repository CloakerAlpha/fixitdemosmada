package com.example.fixitkuv1.sharedpref

import android.app.Application
import android.content.Context

class FixAppClassSession: Application() {
    companion object{
        lateinit var sessionManager: SessionManager
        private lateinit var context: Context
    }

    override fun onCreate(){
        super.onCreate()
        context = this
        sessionManager = SessionManager(context)
    }
}