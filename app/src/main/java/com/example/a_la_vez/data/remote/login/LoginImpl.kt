package com.example.a_la_vez.data.remote.login

import com.example.a_la_vez.data.remote.ApiProvider
import com.example.a_la_vez.feature.login.model.LoginRequest
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class LoginImpl {
    private fun provideRegisterApi(): LoginApi =
        ApiProvider.RetroFitBuilder.create(LoginApi::class.java)

    fun loginApi(request: LoginRequest): @NonNull Single<Response<Void>> =
        provideRegisterApi().login(request)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

}