package com.example.peoplelist.mvp.peopleList

import com.example.peoplelist.data.DataManager
import com.example.peoplelist.mvp.BasePresenterImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeoplePresenter (private val dataManager: DataManager) :
    BasePresenterImpl<PeopleContract.View>(),
    PeopleContract.Presenter {

    private lateinit var call: Call<com.example.peoplelist.data.model.Response>

    override fun loadUser(page: Int) {
        mvpView.let { it ->
            it?.showProgress()
            call = dataManager.getUserList(page)
            call.enqueue(object : Callback<com.example.peoplelist.data.model.Response> {

                override fun onResponse(
                    call: Call<com.example.peoplelist.data.model.Response>,
                    response: Response<com.example.peoplelist.data.model.Response>
                ) {
                    it?.hideProgress()
                    if (response.isSuccessful) {
                        response.body()?.let { res ->
                            it?.showUsers(response.body()?.getResults())
                        }
                    }
                }

                override fun onFailure(
                    call: Call<com.example.peoplelist.data.model.Response>,
                    t: Throwable
                ) {
                    it?.hideProgress()
                    it?.noConnection()
                }
            })
        }
    }

    override fun loadUserPage(page: Int) {
        mvpView.let { it ->
            it?.showProgress()
            call = dataManager.getUserList(page)
            call.enqueue(object : Callback<com.example.peoplelist.data.model.Response> {

                override fun onResponse(
                    call: Call<com.example.peoplelist.data.model.Response>,
                    response: Response<com.example.peoplelist.data.model.Response>
                ) {
                    it?.hideProgress()
                    if (response.isSuccessful) {
                        response.body()?.let { res ->
                            it?.showUsersPage(response.body()?.getResults())
                        }
                    }
                }

                override fun onFailure(
                    call: Call<com.example.peoplelist.data.model.Response>,
                    t: Throwable
                ) {
                    it?.hideProgress()
                    it?.noConnection()
                }
            })
        }
    }

    override fun loadSearchUser(name: String) {
        mvpView.let { it ->
            call = dataManager.getUserSearchList(name)
            call.enqueue(object : Callback<com.example.peoplelist.data.model.Response> {
                override fun onResponse(
                    call: Call<com.example.peoplelist.data.model.Response>,
                    response: Response<com.example.peoplelist.data.model.Response>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { res ->
                            it?.showUsers(response.body()?.getResults())
                        }
                    }
                }

                override fun onFailure(
                    call: Call<com.example.peoplelist.data.model.Response>,
                    t: Throwable
                ) {}
            })
        }
    }


}