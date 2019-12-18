package com.example.fitnesstracker.dependency

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.example.fitnesstracker.R
import com.example.fitnesstracker.base.BaseApp
import com.example.fitnesstracker.data.LoginRepo
import com.example.fitnesstracker.data.LoginRepoImpl
import com.example.fitnesstracker.data.online.OnlineUserLogin
import com.facebook.CallbackManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: BaseApp): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    fun provideGoogleSignInClient(context: Context): GoogleSignInClient {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        return GoogleSignIn.getClient(context, gso)
    }

    @Provides
    @Singleton
    fun provideOnlineUserLogin(firebaseAuth: FirebaseAuth):OnlineUserLogin{
        return OnlineUserLogin(firebaseAuth)
    }

    @Provides
    @Singleton
    fun provideLoginRepo(loginRepoImpl:LoginRepoImpl):LoginRepo{
        return loginRepoImpl
    }
}