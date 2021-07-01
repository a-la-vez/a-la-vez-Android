package com.example.a_la_vez.data.remote.login

import com.example.a_la_vez.data.remote.ApiProvider
import com.example.a_la_vez.feature.login.model.RegisterRequest
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class RegisterImpl {
    private fun provideRegisterApi(): RegisterApi =
        ApiProvider.RetroFitBuilder.create(RegisterApi::class.java)

    fun registerApi(request: RegisterRequest): @NonNull Single<Response<Void>> =
        provideRegisterApi().register(request)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

}
