package com.example.peoplelist.mvp.peopleList

import com.example.peoplelist.data.model.Results
import com.example.peoplelist.mvp.BasePresenter
import com.example.peoplelist.mvp.MvpView

interface PeopleContract {
    interface View : MvpView {
        fun showUsersPage(results: ArrayList<Results?>?)
        fun showUsers(results: ArrayList<Results?>?)
        fun showProgress()
        fun hideProgress()
        fun noConnection()
    }

    interface Presenter : BasePresenter<View> {
        fun loadUser(page: Int)
        fun loadUserPage(page: Int)
        fun loadSearchUser(name: String)

    }
}