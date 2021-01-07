package com.example.peoplelist.mvp

interface BasePresenter <V : MvpView?> {
    fun attachView(view: V)
    fun detachView()
}