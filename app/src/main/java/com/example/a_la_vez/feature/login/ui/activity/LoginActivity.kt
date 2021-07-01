package com.example.a_la_vez.feature.login.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a_la_vez.R
import com.example.a_la_vez.base.BaseActivity
import com.example.a_la_vez.databinding.ActivityLoginBinding
import com.example.a_la_vez.databinding.ActivityRegisterBinding
import com.example.a_la_vez.feature.login.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    lateinit var viewmodel : LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
    private fun checkRegister(){

    }
}