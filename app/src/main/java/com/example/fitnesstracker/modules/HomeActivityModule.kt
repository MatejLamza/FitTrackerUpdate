package com.example.fitnesstracker.modules

import com.example.fitnesstracker.factories.HomeActivityVMFactory
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {
    @Provides
    fun provideHomeActivityVMFactory(googleSignInClient: GoogleSignInClient):HomeActivityVMFactory{
        return HomeActivityVMFactory(googleSignInClient)
    }
}