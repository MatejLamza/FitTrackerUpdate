package com.example.fitnesstracker.base

import android.app.Activity
import android.app.Application
import com.example.fitnesstracker.dependency.DaggerAppComponent
import com.google.firebase.FirebaseApp
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class BaseApp: Application(),HasAndroidInjector {

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .setApplication(this)
            .build()
            .inject(this)

        FirebaseApp.initializeApp(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector


}