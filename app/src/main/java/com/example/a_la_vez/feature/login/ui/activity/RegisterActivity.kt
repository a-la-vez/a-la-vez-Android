package com.example.a_la_vez.feature.login.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.example.a_la_vez.R
import com.example.a_la_vez.base.BaseActivity
import com.example.a_la_vez.data.di.module.registerModule
import com.example.a_la_vez.databinding.ActivityRegisterBinding
import com.example.a_la_vez.feature.login.viewmodel.RegisterViewModel
import io.reactivex.rxjava3.core.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(R.layout.activity_register) {

    private val vm : RegisterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkRegister()

    }

    private fun checkRegister(){
        vm.checkRegister.value = vm.EmptyName.value!! && vm.EmptyEmail.value!! && vm.EmptyPassword.value!! && vm.EmptyRePassword.value!!
    }

    private fun DataInput(){
        vm.userName.observe(this,{
            vm.EmptyName.value = !it.isNullOrBlank()
        })
    }
    private fun observeToast() {
        vm.toastMessage.observe(this, { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })
    }


}