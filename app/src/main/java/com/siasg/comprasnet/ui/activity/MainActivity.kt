package com.siasg.comprasnet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.siasg.comprasnet.R
import com.siasg.comprasnet.ui.fragment.login.LoginFragment
import com.siasg.comprasnet.ui.fragment.main.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var toolbar: ActionBar

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.menu_home  ->  {
                val homeFragment = HomeFragment()
                openFragment(homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_conta -> {
                val accountFragment = LoginFragment()
                openFragment(accountFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_mapa  ->  return@OnNavigationItemSelectedListener true
            R.id.menu_mais  ->  return@OnNavigationItemSelectedListener true
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.barNavigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

}