package com.example.peoplelist.mvp.peopleInfo

import com.example.peoplelist.data.model.Results
import com.example.peoplelist.mvp.BasePresenter
import com.example.peoplelist.mvp.MvpView

interface PeopleInfoContract{
    interface View : MvpView {
        fun showUserInfo(results: Results)
        fun showProgress()
        fun hideProgress()
        fun noConnection()
    }

    interface Presenter : BasePresenter<View> {
        fun loadUserInfo(url: String)
    }
}