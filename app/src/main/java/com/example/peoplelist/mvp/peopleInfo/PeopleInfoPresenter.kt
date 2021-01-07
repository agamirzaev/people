package com.example.peoplelist.mvp.peopleInfo

import android.util.Log
import com.example.peoplelist.data.DataManager
import com.example.peoplelist.data.model.Results
import com.example.peoplelist.mvp.BasePresenter
import com.example.peoplelist.mvp.BasePresenterImpl
import com.example.peoplelist.mvp.MvpView
import retrofit2.Call
import retrofit2.Callback

class PeopleInfoPresenter (private val dataManager: DataManager) :
    BasePresenterImpl<PeopleInfoContract.View>(),
    PeopleInfoContract.Presenter {

    private lateinit var call: Call<Results>

    override fun loadUserInfo(url: String) {
        mvpView.let { it ->
            it?.showProgress()
            call = dataManager.getUserInfo(url)
            call.enqueue(object : Callback<Results> {

                override fun onResponse(
                    call: Call<Results>,
                    response: retrofit2.Response<Results>
                ) {
                    it?.hideProgress()
                    if (response.isSuccessful) {
                        response.body()?.let { res ->
                            it?.showUserInfo(response.body()!!)
                            Log.e("qqq", call.request().toString())
                        }
                    }
                }

                override fun onFailure(
                    call: Call<Results>,
                    t: Throwable
                ) {
                    it?.hideProgress()
                    it?.noConnection()
                }
            })
        }
    }

}