package com.example.a_la_vez.feature.login.viewmodel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a_la_vez.data.remote.login.RegisterImpl
import com.example.a_la_vez.feature.login.model.RegisterRequest

class RegisterViewModel(private val apiImpl: RegisterImpl) : ViewModel() {

    val userName = MutableLiveData<String>()
    val emptyName = MutableLiveData<Boolean>(false)

    val userEmail = MutableLiveData<String>()
    val emptyEmail = MutableLiveData<Boolean>(false)

    val userPassword = MutableLiveData<String>()
    val emptyPassword = MutableLiveData<Boolean>(false)

    val userRePassword = MutableLiveData<String>()
    val emptyRePassword = MutableLiveData<Boolean>(false)

    val checkRegister = MutableLiveData<Boolean>(false)

    private val _successRegister = MutableLiveData<Boolean>(false)
    private val successRegister: LiveData<Boolean> get() = _successRegister

    private val __failedRegister = MutableLiveData<Boolean>(false)
    private val failedRegister: LiveData<Boolean> get() = __failedRegister

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> get() = _toastMessage


    fun doRegister() {
        if (checkRegister.value == true) {
            val request = RegisterRequest(
                userName.value!!,
                userEmail.value!!,
                userPassword.value!!,
                userRePassword.value!!
            )
            apiImpl.registerApi(request).subscribe { subscrible ->
                when (subscrible.code()) {
                    200 -> {
                        _toastMessage.value = ("회원가입에 성공하였습니다")
                        _successRegister.value = true
                    }
                    400 -> {
                        if (subscrible.message() == "This email is already registered.") {
                            _toastMessage.value = ("이미 등록된 이메일 입니다")
                            __failedRegister
                        } else if (subscrible.message() == "password and re_password are diffirent") {
                            _toastMessage.value = ("입력하신 비밀번호가 맞는지 다시 확인해주세요")
                            __failedRegister
                        }

                    }
                }
            }

        }
    }
}
