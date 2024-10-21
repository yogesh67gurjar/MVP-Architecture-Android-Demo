package com.yogesh.mvpdemo.contract

interface Contract {
    interface View {
        fun showProgress()
        fun hideProgress()
        fun onSuccess(type: String, data: Any)
        fun onFailure(message: String)
    }

    interface Presenter {
        fun getFact()
    }
}