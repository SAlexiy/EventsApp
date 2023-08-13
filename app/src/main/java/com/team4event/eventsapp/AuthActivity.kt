package com.team4event.eventsapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.team4event.eventsapp.databinding.ActivityAuthBinding
import com.team4event.eventsapp.databinding.ActivityMainBinding
import com.team4event.eventsapp.ui.fragments.auth.AuthFragment
import com.team4event.eventsapp.ui.fragments.events.EventsFragment

class AuthActivity : AppCompatActivity() {
    companion object{
        lateinit var settings: SharedPreferences
    }

    private lateinit var binding : ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        settings = getSharedPreferences("PreferencesName", MODE_PRIVATE)

        replaceFragment(AuthFragment.newInstance())
    }


    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.auth_frame_layout,fragment)
        fragmentTransaction.commit()
    }
}