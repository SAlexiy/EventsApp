package com.team4event.eventsapp.ui.fragments.events.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.team4event.eventsapp.ui.elements.PasswordField
import com.team4event.eventsapp.ui.elements.StandardButton
import com.team4event.eventsapp.ui.elements.TextFieldCustom
import com.team4event.eventsapp.ui.fragments.auth.AuthFragment
import com.team4event.eventsapp.ui.fragments.events.EventsFragment
import com.team4event.eventsapp.ui.fragments.events.EventsViewModel


@Composable
fun AfishaTab() {
    val viewModel = EventsFragment.viewModel


}