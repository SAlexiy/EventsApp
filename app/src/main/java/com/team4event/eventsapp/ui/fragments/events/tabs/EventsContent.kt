package com.team4event.eventsapp.ui.fragments.events.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.team4event.eventsapp.ui.fragments.events.EventsFragment
import com.team4event.eventsapp.ui.theme.Purple

@Composable
fun EventsContent(){
    val viewModel = EventsFragment.viewModel
    val page = viewModel.currentPage.value.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()) {

            Box(modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(0.5f)
                .background(color = if (page.value == 0) Purple else Color.White
                )
                .clickable { viewModel.currentPage.setValue(0) },
                contentAlignment = Alignment.Center) {
                Text(text = "Events")
            }

            Box(modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .background(color = if (page.value == 1) Purple else Color.White
                )
                .clickable { viewModel.currentPage.setValue(1) },
                contentAlignment = Alignment.Center) {
                Text(text = "Afisha")
            }
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
            .background(color = Color.Black))


        Box(modifier = Modifier
            .fillMaxSize()) {
            when (page.value){
                0 -> {EventsTab()}
                1 -> {AfishaTab()}
                else -> {}
            }
        }

    }
}