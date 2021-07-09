package com.example.a_la_vez.data.remote.login

import com.example.a_la_vez.feature.login.model.LoginRequest
import com.example.a_la_vez.feature.login.model.RegisterRequest
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("/auth/login")
    fun login(@Body request: LoginRequest): Single<Response<Void>>

}
