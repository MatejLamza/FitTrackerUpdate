package com.example.fitnesstracker.views

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.fitnesstracker.R
import com.example.fitnesstracker.factories.LoginActivityVMFactory
import com.example.fitnesstracker.utils.MyConstants
import com.example.fitnesstracker.utils.listeners.ActivityNavigation
import com.example.fitnesstracker.viewmodels.LoginActivityViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject


class LoginActivity : AppCompatActivity(), ActivityNavigation {

    @Inject
    lateinit var  loginVMFactory:LoginActivityVMFactory
    
    private lateinit var loginVM:LoginActivityViewModel

    override fun onStart() {
        super.onStart()
        loginVM.checkIfUserIsLoggedIn(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setVideoBackground()

        loginVM = ViewModelProviders.of(this,loginVMFactory).get(LoginActivityViewModel::class.java)

        loginVM.startActivityForResultEvent.setEventReceiver(this,this)

        btn_sign_in_google.setOnClickListener {
            loginVM.googleSignIn()
        }

        loginVM.loginSuccess.observe(this, Observer {
            if (it){
               loginVM.forwardToHomeScreen(this)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        loginVM.onResultFromActivity(requestCode,data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun setVideoBackground() {
        val videoView = findViewById<VideoView>(R.id.vv_bg_video)
        val uri =
            Uri.parse(MyConstants.VIDEO_URI_STRING + packageName + '/' + R.raw.background_video)

        videoView.setVideoURI(uri)
        videoView.start()

        videoView.setOnPreparedListener {
            it.isLooping = true
        }
    }
}