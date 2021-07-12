package com.example.a_la_vez.feature.login.viewmodel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a_la_vez.MainActivity
import com.example.a_la_vez.data.remote.login.LoginApi
import com.example.a_la_vez.data.remote.login.LoginImpl
import com.example.a_la_vez.feature.login.model.LoginRequest
import com.example.a_la_vez.feature.login.model.RegisterRequest
import com.example.a_la_vez.feature.login.ui.activity.LoginActivity
import org.koin.core.qualifier.named

class LoginViewModel(private val loginImpl: LoginImpl) : ViewModel() {

    private val nonSign=  MutableLiveData<Boolean>(false)

    private val doLogin = MutableLiveData<Boolean>(false)

    val userLogin = MutableLiveData<String>()

    val userPassword = MutableLiveData<String>()

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage : LiveData<String> get() = _toastMessage


    fun doLogin() {
        if (doLogin.value!!) {
            val request = LoginRequest(userLogin.value!!, userPassword.value!!)
            loginImpl.loginApi(request).subscribe { subscrible ->
                when (subscrible.code()) {
                    200 -> {
                        _toastMessage.value = "로그인에 성공하였습니다!"


                    }
                    400 -> {
                        _toastMessage.value = "가입이 안된 계정 입니다"

                    }
                    else -> {
                        _toastMessage.value ="로그인에 실패하였습니다"

                    }
                }
            }
        }
    }

    fun checkSign(){
        userLogin.value= null
        userPassword.value = null
        nonSign.value = true
    }
}
