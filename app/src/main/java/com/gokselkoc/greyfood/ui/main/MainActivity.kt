package com.gokselkoc.greyfood.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.gokselkoc.greyfood.R
import com.gokselkoc.greyfood.databinding.ActivityMainBinding
import com.gokselkoc.greyfood.ui.basket.BasketActivity
import com.gokselkoc.greyfood.ui.login.LoginActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this


        bottomMenuNavGraph(binding.mainFragmentNavHost.id, binding.mainBottomMenuNav)

        binding.cardView.setOnClickListener {
            startActivity(Intent(this, BasketActivity::class.java))
        }

        binding.toolbarLoginImageView.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.toolbarListImageView.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun bottomMenuNavGraph(navHostFragmentId: Int, bottomMenuView: BottomNavigationView) {
        navHostFragment =
            supportFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment
        navController = navHostFragment.navController
        bottomMenuView.setupWithNavController(navController)
    }
}