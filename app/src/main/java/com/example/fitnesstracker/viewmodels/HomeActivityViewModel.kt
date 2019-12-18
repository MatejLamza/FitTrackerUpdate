package com.example.fitnesstracker.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import javax.inject.Inject

class HomeActivityViewModel
   @Inject constructor(val googleSignInClient: GoogleSignInClient) :ViewModel() {

    fun googleSignOut(){
       googleSignInClient.signOut()
    }

}