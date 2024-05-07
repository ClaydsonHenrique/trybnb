package com.betrybe.trybnb.ui.views.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.betrybe.trybnb.R
import com.betrybe.trybnb.ui.views.fragments.CreateReservationFragment
import com.betrybe.trybnb.ui.views.fragments.ProfileFragment
import com.betrybe.trybnb.ui.views.fragments.ReservationFragment
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.reservation_menu_item -> {
                loadFragment(R.id.reservation_frame_layout, ReservationFragment())
                return true
            }
            R.id.create_reservation_menu_item -> {
                loadFragment(R.id.create_reservation_scroll_view, CreateReservationFragment())
                return true
            }
            R.id.profile_menu_item -> {
                loadFragment(R.id.profile_scroll_view, ProfileFragment())
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loadFragment(containerId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .commit()
    }

}
