package com.team4event.eventsapp

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.Fragment
import com.team4event.eventsapp.consts.SharedPreferenceKeys.AUTH_KEY
import com.team4event.eventsapp.databinding.ActivityMainBinding
import com.team4event.eventsapp.ui.fragments.events.EventsFragment
import com.team4event.eventsapp.ui.fragments.map.MapFragment
import com.team4event.eventsapp.ui.fragments.profile.ProfileFragment


class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var settings: SharedPreferences
        var authKey: String? = null
    }

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(EventsFragment.newInstance())

        settings = getSharedPreferences("PreferencesName", MODE_PRIVATE)
        authKey = settings.getString(AUTH_KEY, "")

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){

                R.id.event -> replaceFragment(EventsFragment.newInstance())
                R.id.map -> replaceFragment(MapFragment.newInstance())
                //R.id.profile -> replaceFragment(ProfileFragment.newInstance())

                else ->{ }
            }

            true
        }




    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}
