package com.example.peoplelist.mvp

open class BasePresenterImpl <T : MvpView?> :
    BasePresenter<T> {
    var mvpView: T? = null
        private set

    override fun attachView(view: T) {
        mvpView = view
    }

    override fun detachView() {
        mvpView = null
    }
}