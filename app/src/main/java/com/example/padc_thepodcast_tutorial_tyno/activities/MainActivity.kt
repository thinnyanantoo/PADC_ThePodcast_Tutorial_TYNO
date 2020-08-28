package com.example.padc_thepodcast_tutorial_tyno.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.padc_thepodcast_tutorial_tyno.R
import com.example.padc_thepodcast_tutorial_tyno.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener (
            object :
                BottomNavigationView.OnNavigationItemSelectedListener {
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    when (item.itemId) {
                        R.id.item_bottom_navigation_home -> {
                            supportFragmentManager.beginTransaction().replace(
                                R.id.frameContainer, HomeFragment.newInstance("A", "B")
                            )
                                .commit()
                            return true
                        }
                        R.id.item_bottom_navigation_search -> {
                            supportFragmentManager.beginTransaction().replace(
                                R.id.frameContainer, SearchFragment.newInstance("A", "B")
                            )
                                .commit()
                            return true

                        }
                        R.id.item_bottom_navigation_download -> {
                            supportFragmentManager.beginTransaction().replace(
                                R.id.frameContainer, DownloadFragment.newInstance("A", "B")
                            )
                                .commit()
                            return true

                        }
                        R.id.item_bottom_navigation_profile -> {
                            supportFragmentManager.beginTransaction().replace(
                                R.id.frameContainer, ProfileFragment.newInstance("A", "B")
                            )
                                .commit()
                            return true
                        }
                    }
                    return false

                }

            })
        }
    }


