package com.example.fitnesstracker.dependency

import com.example.fitnesstracker.modules.HomeActivityModule
import com.example.fitnesstracker.modules.LoginActivityModule
import com.example.fitnesstracker.views.HomeActivity
import com.example.fitnesstracker.views.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(LoginActivityModule::class))
    abstract fun bindsLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = arrayOf(HomeActivityModule::class))
    abstract fun bindHomeActivity(): HomeActivity

}