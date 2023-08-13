package com.team4event.eventsapp.ui.fragments.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team4event.eventsapp.MainActivity
import com.team4event.eventsapp.datamodels.event.Event
import com.team4event.eventsapp.flow.ValueStateFlow
import com.team4event.eventsapp.network.events.EventsRepository
import kotlinx.coroutines.launch

class EventsViewModel() : ViewModel() {
    private val eventsRepository = EventsRepository(token = "${MainActivity.authKey}")

    val currentPage = ValueStateFlow<Int>(0)

    val eventList = ValueStateFlow<List<Event>>(listOf())
    val afishaList = ValueStateFlow<List<Event>>(listOf())


    fun getEvents() {
        viewModelScope.launch {
            eventList.setValue(eventsRepository.getEvents()!!)
        }
    }

    companion object{
        private var instance: EventsViewModel? = null

        fun getInstance(): EventsViewModel {
            if (instance == null){
                instance = EventsViewModel()
            }

            return instance!!
        }
    }
}