package com.example.fitnesstracker.data.online

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import javax.inject.Inject

class OnlineUserLogin
@Inject constructor(val firebaseAuth: FirebaseAuth) {

    fun firebaseAuthWithGoogle(acct: GoogleSignInAccount): MutableLiveData<Boolean>{
        var liveLoginSuccess: MutableLiveData<Boolean> = MutableLiveData()
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)

        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("aaa", "signInWithCredential:success")
                    liveLoginSuccess.value = true
                } else {
                    Log.w("aaa", "signInWithCredential:failure", task.exception)
                    liveLoginSuccess.value = false
                }
            }
        return liveLoginSuccess
    }
}