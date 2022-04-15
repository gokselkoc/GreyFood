package com.gokselkoc.greyfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.gokselkoc.greyfood.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        bottomMenuNavGraph(binding.mainFragmentNavHost.id, binding.mainBottomMenuNav)

    }


    private fun bottomMenuNavGraph(navHostFragmentId: Int, bottomMenuView: BottomNavigationView) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment
        navController = navHostFragment.navController
        bottomMenuView.setupWithNavController(navController)
    }
}