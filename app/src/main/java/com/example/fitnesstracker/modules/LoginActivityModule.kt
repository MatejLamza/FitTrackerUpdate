package com.example.fitnesstracker.modules

import com.example.fitnesstracker.data.LoginRepo
import com.example.fitnesstracker.factories.LoginActivityVMFactory
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import dagger.Module
import dagger.Provides

@Module
class LoginActivityModule {
    @Provides
    fun provideLoginActivityVMFactory(loginRepo: LoginRepo, mGoogleSignInClient: GoogleSignInClient):LoginActivityVMFactory{
        return LoginActivityVMFactory(loginRepo,mGoogleSignInClient)
    }
}