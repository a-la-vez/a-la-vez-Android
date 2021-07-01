package com.example.a_la_vez.data.di.module

import com.example.a_la_vez.data.remote.login.LoginImpl
import com.example.a_la_vez.feature.login.viewmodel.RegisterViewModel
import io.reactivex.rxjava3.schedulers.Schedulers.single
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val registerModule = module {
    single { LoginImpl() }

    viewModel { RegisterViewModel(get()) }

}