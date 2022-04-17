package com.gokselkoc.greyfood.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.gokselkoc.greyfood.R
import com.gokselkoc.greyfood.databinding.ActivityBasketBinding

class BasketActivity : AppCompatActivity() {
    lateinit var binding: ActivityBasketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_basket)
        binding.lifecycleOwner = this
    }
}