package com.yogesh.mvpdemo.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yogesh.mvpdemo.R
import com.yogesh.mvpdemo.contract.Contract
import com.yogesh.mvpdemo.databinding.ActivityMainBinding
import com.yogesh.mvpdemo.model.CatFactResponse
import com.yogesh.mvpdemo.presenter.MainPresenter

class MainActivity : AppCompatActivity(), Contract.View {
    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        presenter = MainPresenter(this)

        binding.btn.setOnClickListener {
            presenter.getFact()
        }
    }

    override fun showProgress() {
        binding.loader.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.loader.visibility = View.GONE
    }

    override fun onSuccess(type: String, data: Any) {
        if (type == "CatFact") {
            binding.tv.text = (data as CatFactResponse).fact
        }
    }

    override fun onFailure(message: String) {
        binding.tv.text = message
    }
}