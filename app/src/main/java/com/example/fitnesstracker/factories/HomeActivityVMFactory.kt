package com.example.fitnesstracker.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fitnesstracker.viewmodels.HomeActivityViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import java.lang.IllegalArgumentException
import javax.inject.Inject

class HomeActivityVMFactory
    @Inject constructor(val googleSignInClient: GoogleSignInClient):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      if (modelClass.isAssignableFrom(HomeActivityViewModel::class.java)){
          return HomeActivityViewModel(googleSignInClient) as T
      } else{
          throw IllegalArgumentException("Unkown class HomeActivityViewModel!!")
      }
    }
}