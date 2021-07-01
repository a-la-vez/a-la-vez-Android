package com.example.a_la_vez.data.remote.login

import com.example.a_la_vez.feature.login.model.RegisterRequest
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterApi {
    @POST("/auth/join")
    fun register(@Body request: RegisterRequest): Single<Response<Void>>


}