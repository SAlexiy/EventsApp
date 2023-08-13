package com.team4event.eventsapp.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun imageFromURL(url: String) {
    Box(modifier = Modifier
        .size(100.dp)) {
        Image(
            painter = rememberAsyncImagePainter(url),
            contentDescription = "gfg image",
            modifier = Modifier
                .wrapContentSize()
        )
    }

}