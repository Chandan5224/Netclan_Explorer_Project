package com.example.netclanexplorerproject

import android.content.res.Resources
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.ui.AppBarConfiguration
import com.example.netclanexplorerproject.Fragments.ExploreFrag
import com.example.netclanexplorerproject.Fragments.RefineFrag
import com.example.netclanexplorerproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(RefineFrag())
        setDrawerToggle()
        setupToolbar()
        bottomNavHandle()

    }


    private fun bottomNavHandle() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.refine_bottom_nav -> {
//                    it.icon?.setColorFilter(resources.getColor(R.color.toolbar_color), PorterDuff.Mode.SRC_IN)
                    replaceFragment(RefineFrag())
                }
                R.id.explore_bottom_nav -> {
//                    it.icon?.setColorFilter(resources.getColor(R.color.toolbar_color), PorterDuff.Mode.SRC_IN)
                    replaceFragment(ExploreFrag())
                }
            }

            return@setOnItemSelectedListener true
        }
    }

    private fun replaceFragment(frag: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, frag)
            .commit()
    }

    private fun setDrawerToggle() {
        // toggle the drawer
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            binding.drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
//        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.mToolBar)
        supportActionBar?.title = ""
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_action_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

}