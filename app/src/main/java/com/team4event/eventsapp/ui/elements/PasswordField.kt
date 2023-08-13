package com.team4event.eventsapp.ui.elements



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(padding: Int = 10, label: String,
               textState: String, onValueChange: (String) -> Unit
){

    val focusedColor = Color.Blue
    val unfocusedColor = Color.Black
    val backgroundColor = Color.Transparent

    Box(modifier = Modifier
        .clip(RoundedCornerShape(4.dp))
        .padding(horizontal = padding.dp, vertical = 5.dp)) {
        TextField(
            value = textState,
            onValueChange = { onValueChange(it) },
            modifier = Modifier
                .width(328.dp),
            label = { Text(text = label) },
            singleLine = false,
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = focusedColor,
                focusedLabelColor = focusedColor.copy(alpha = 0.54f),
                unfocusedLabelColor = unfocusedColor.copy(alpha = 0.54f),
                textColor = unfocusedColor,
                containerColor = backgroundColor,
                focusedIndicatorColor = focusedColor,
                unfocusedIndicatorColor = unfocusedColor,
            )
        )
    }
}

