package com.team4event.eventsapp.ui.fragments.events.tabs


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.team4event.eventsapp.ui.fragments.events.EventsFragment


@Composable
fun EventsTab(){
    val viewModel = EventsFragment.viewModel
    viewModel.getEvents()
    val events = viewModel.eventList.value.collectAsState()

    LazyColumn(modifier = Modifier
        .fillMaxSize()){
        items(events.value.count()) {
            EventUnit(event = events.value[it])
        }
    }
}