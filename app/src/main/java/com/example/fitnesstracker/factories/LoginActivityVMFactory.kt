package com.example.fitnesstracker.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fitnesstracker.data.LoginRepo
import com.example.fitnesstracker.viewmodels.LoginActivityViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import java.lang.IllegalArgumentException
import javax.inject.Inject

class LoginActivityVMFactory
@Inject constructor(val loginRepo:LoginRepo, val mGoogleSignInClient: GoogleSignInClient) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       if(modelClass.isAssignableFrom(LoginActivityViewModel::class.java)){
           return LoginActivityViewModel(loginRepo,mGoogleSignInClient) as T
       } else{
           throw IllegalArgumentException("Unknown LoginViewModel class!")
       }
    }
}