package com.yogesh.mvpdemo.presenter

import com.yogesh.mvpdemo.contract.Contract
import com.yogesh.mvpdemo.model.CatFactResponse
import com.yogesh.mvpdemo.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainPresenter(var view: Contract.View) : Contract.Presenter {
    private val apiService: ApiService = Retrofit.Builder().baseUrl("https://catfact.ninja/")
        .addConverterFactory(GsonConverterFactory.create()).build().create()

    override fun getFact() {
        view.showProgress()
        apiService.getFact().enqueue(object : Callback<CatFactResponse> {
            override fun onResponse(
                call: Call<CatFactResponse>,
                response: Response<CatFactResponse>
            ) {
                if (response.isSuccessful) {
                    view.onSuccess("CatFact", response.body()!!)
                } else {
                    view.onFailure(response.message())
                }
                view.hideProgress()
            }

            override fun onFailure(call: Call<CatFactResponse>, throwable: Throwable) {
                view.onFailure(throwable.message.toString())
                view.hideProgress()
            }
        })

    }
}