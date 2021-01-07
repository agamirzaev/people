package com.example.peoplelist.data.remote

import com.example.peoplelist.data.model.Response
import com.example.peoplelist.data.model.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("api/people/")
    fun userList(
        @Query("page") page: Int
    ): Call<Response>

    @GET("")
    fun userInfo(
        @Path("url") url: String
    ): Call<Results>

    @GET("api/people/")
    fun userSearchList(
        @Query("search") search: String
    ): Call<Response>

}