package com.team4event.eventsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.team4event.eventsapp.databinding.ActivityMainBinding
import com.team4event.eventsapp.ui.screens.events.EventsFragment
import com.team4event.eventsapp.ui.screens.map.MapFragment
import com.team4event.eventsapp.ui.screens.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(EventsFragment.newInstance())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.event -> replaceFragment(EventsFragment.newInstance())
                R.id.map -> replaceFragment(MapFragment.newInstance())
                R.id.profile -> replaceFragment(ProfileFragment.newInstance())

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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

