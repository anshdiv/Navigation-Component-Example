package com.appzgarden.navigationpoc

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private var mainViewModel: MainViewModel? = null
    private var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        mainViewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        configNavigation()
        nav_view.setNavigationItemSelectedListener(this)
    }

    private fun configNavigation() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        NavigationUI.setupWithNavController(
            bottom_navigation_view,
            navHostFragment!!.getNavController()
        )
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawer_layout
        )

        NavigationUI.setupActionBarWithNavController(
            this,
            navController!!,
            drawer_layout
        )
        NavigationUI.setupWithNavController(
            toolbar,
            navController!!,
            appBarConfiguration
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(menu: MenuItem): Boolean {
        when (menu.itemId) {
            R.id.nav_school_1 -> {
                mainViewModel?.schoolName?.value = "School 1"
            }
            R.id.nav_school_2 -> {
                mainViewModel?.schoolName?.value = "School 2"
            }
            R.id.nav_school_3 -> {
                mainViewModel?.schoolName?.value = "School 3"
            }
            R.id.nav_school_4 -> {
                mainViewModel?.schoolName?.value = "School 4"
            }
        }
        drawer_layout.closeDrawers()
        return true
    }
}
