package com.example.fitnesstracker.data

import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

interface LoginRepo {
    //Online
    fun firebaseAuthWithGoogle(account:GoogleSignInAccount):MutableLiveData<Boolean>
}