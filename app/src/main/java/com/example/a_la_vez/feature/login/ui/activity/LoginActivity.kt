package com.example.a_la_vez.feature.login.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

    private var lastTimeBackPressed: Long = -1500

    override fun onBackPressed() {
        if (System.currentTimeMillis() - lastTimeBackPressed <= 1500) {
            moveTaskToBack(true)
            finish()
            android.os.Process.killProcess(android.os.Process.myPid())
        }
        lastTimeBackPressed = System.currentTimeMillis()
        Toast.makeText(this, "뒤로가기 버튼을 한 번 더 누르면 종료됩니다", Toast.LENGTH_SHORT).show()

    }

    fun checkUp(){
        val checkRegister = Intent(this,RegisterActivity::class.java)
        startActivity(checkRegister)
    }
}