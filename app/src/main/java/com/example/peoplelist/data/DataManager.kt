package com.example.peoplelist.data

import com.example.peoplelist.data.model.Response
import com.example.peoplelist.data.model.Results
import com.example.peoplelist.data.remote.Api
import com.example.peoplelist.data.remote.ServicesGenerator
import retrofit2.Call

class DataManager {
    private val api = ServicesGenerator.createService(Api::class.java)

    fun getUserList(page: Int): Call<Response> {
        return api.userList(page)
    }

    fun getUserSearchList(search: String): Call<Response> {
        return api.userSearchList(search)
    }

    fun getUserInfo(url: String): Call<Results> {
        return api.userInfo(url)
    }
}