package com.example.fitnesstracker.viewmodels


import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.*
import com.example.fitnesstracker.data.LoginRepo
import com.example.fitnesstracker.data.models.User
import com.example.fitnesstracker.utils.MyConstants
import com.example.fitnesstracker.utils.helpers.LiveMessageEvent
import com.example.fitnesstracker.utils.listeners.ActivityNavigation
import com.example.fitnesstracker.views.HomeActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import javax.inject.Inject


class LoginActivityViewModel
@Inject constructor(val loginRepo: LoginRepo, val mGoogleSignInClient: GoogleSignInClient) :
    ViewModel() {

    val startActivityForResultEvent = LiveMessageEvent<ActivityNavigation>()
    var loginSuccess: MediatorLiveData<Boolean> = MediatorLiveData()
    var liveUser: MutableLiveData<User> = MutableLiveData()


    fun checkIfUserIsLoggedIn(context: Context) {
        val currentSingedAccount = GoogleSignIn.getLastSignedInAccount(context)
        if (currentSingedAccount != null){
            forwardToHomeScreen(context)
        }
    }

    fun googleSignIn() {
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResultEvent.sendEvent {
            startActivityForResult(
                signInIntent,
                MyConstants.RC_SIGN_IN
            )
        }
    }

    fun onResultFromActivity(requestCode: Int, data: Intent?) {

        when (requestCode) {
            MyConstants.RC_SIGN_IN -> {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    val account = task.getResult(ApiException::class.java)
                    if (account != null) {
                        //TODO Save data in firestore
                        val user = User(account.id!!, account.email!!)
                        liveUser.value = user
                    }
                    loginSuccess.addSource(loginRepo.firebaseAuthWithGoogle(account!!)) {
                        loginSuccess.value = it
                    }
                } catch (e: ApiException) {
                    Log.w("aaa", "Google sign in failed", e)
                }
            }
        }
    }

    fun forwardToHomeScreen(context: Context) {
        val intent = Intent(context, HomeActivity::class.java)
        context.startActivity(intent)
    }
}