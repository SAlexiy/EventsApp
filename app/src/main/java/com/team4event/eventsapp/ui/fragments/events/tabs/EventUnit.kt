package com.team4event.eventsapp.ui.fragments.events.tabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.team4event.eventsapp.datamodels.event.Event
import com.team4event.eventsapp.ui.elements.imageFromURL


@Composable
fun EventUnit(event: Event){
    Column {

        Spacer(modifier = Modifier
            .fillMaxSize())

        Row(modifier = Modifier
            .padding(vertical = 20.dp)
            ) {
            Box {
                imageFromURL(event.img!!)
            }

            Column {
                Text(text = event.title!!)

                Row {
                    Text(text = event.dataStart!!)
                    Text(text = event.dataEnd!!)
                }

                Text(text = event.title!!)
            }


        }
    }
}