package com.example.fitnesstracker.data

import androidx.lifecycle.MutableLiveData
import com.example.fitnesstracker.data.online.OnlineUserLogin
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import javax.inject.Inject

class LoginRepoImpl
    @Inject constructor(val onlineUserLogin:OnlineUserLogin):LoginRepo {

    override fun firebaseAuthWithGoogle(account: GoogleSignInAccount):MutableLiveData<Boolean>{
        return onlineUserLogin.firebaseAuthWithGoogle(account)
    }
}