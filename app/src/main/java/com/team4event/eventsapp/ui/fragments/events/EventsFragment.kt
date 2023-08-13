package com.team4event.eventsapp.ui.fragments.events

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import cafe.adriel.voyager.navigator.Navigator
import com.team4event.eventsapp.R
import com.team4event.eventsapp.ui.fragments.auth.AuthFragment
import com.team4event.eventsapp.ui.fragments.auth.AuthViewModel
import com.team4event.eventsapp.ui.fragments.auth.screens.LoginScreen
import com.team4event.eventsapp.ui.fragments.events.tabs.EventsContent
import com.team4event.eventsapp.ui.fragments.events.tabs.EventsTab

class EventsFragment : Fragment() {

    companion object {
        fun newInstance() = EventsFragment()
        lateinit var viewModel: EventsViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = EventsViewModel.getInstance()
        return inflater.inflate(R.layout.fragment_events, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val composeView = view.findViewById<ComposeView>(R.id.events_compose)
        composeView.setContent {
            EventsContent()
        }
    }

}