package co.ghostnotes.sample.bottomnavigation.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import co.ghostnotes.sample.bottomnavigation.R
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        bottom_navigation.setOnNavigationItemSelectedListener(OnBottomNavigationItemSelectedListener(this))

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, RecentsFragment.newInstance())
                commitNow()
            }
        }
    }

    override fun setPage(page: Page) {
        val fragment = when (page) {
            Page.RECENTS -> RecentsFragment.newInstance()
            Page.FAVORITES -> FavoritesFragment.newInstance()
            Page.NEARBY -> NearbyFragment.newInstance()
        }

        replaceFragment(fragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }
    }

    internal class OnBottomNavigationItemSelectedListener(private val view: MainContract.View): BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.navigation_recents -> {
                    view.setPage(Page.RECENTS)
                    return true
                }
                R.id.navigation_favorites -> {
                    view.setPage(Page.FAVORITES)
                    return true
                }
                R.id.navigation_nearby -> {
                    view.setPage(Page.NEARBY)
                    return true
                }
            }

            return false
        }
    }

}
