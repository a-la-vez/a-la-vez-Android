package com.example.a_la_vez.feature.login.ui.activity

import android.os.Bundle
import android.widget.Toast
import com.example.a_la_vez.R
import com.example.a_la_vez.base.BaseActivity
import com.example.a_la_vez.databinding.ActivityRegisterBinding
import com.example.a_la_vez.feature.login.viewmodel.RegisterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(R.layout.activity_register) {

    private val vm : RegisterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkRegister()

    }

    private fun checkRegister(){
        vm.checkRegister.value = vm.emptyName.value!! && vm.emptyEmail.value!! && vm.emptyPassword.value!! && vm.emptyRePassword.value!!
    }

    private fun DataInput(){
        vm.userName.observe(this,{
            vm.emptyName.value = !it.isNullOrBlank()
        })
    }
    private fun observeToast() {
        vm.toastMessage.observe(this, { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })
    }


}