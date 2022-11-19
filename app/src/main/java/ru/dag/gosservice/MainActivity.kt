package ru.dag.gosservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationFragment = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)?.findNavController()

        navController?.let { bottomNavigationFragment.setupWithNavController(it) }

    }
}