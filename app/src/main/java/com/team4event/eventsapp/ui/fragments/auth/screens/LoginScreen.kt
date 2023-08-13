package com.team4event.eventsapp.ui.fragments.auth.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.team4event.eventsapp.ui.elements.PasswordField
import com.team4event.eventsapp.ui.elements.StandardButton
import com.team4event.eventsapp.ui.elements.TextFieldCustom
import com.team4event.eventsapp.ui.fragments.auth.AuthFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf


class LoginScreen(): Screen {
    private val viewModel = AuthFragment.viewModel

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
            contentAlignment = Alignment.Center) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Column {
                    val login = viewModel.login.value.collectAsState()
                    TextFieldCustom(
                        label = "Login",
                        textState = login.value,
                        onValueChange = { viewModel.login.setValue(it) }
                    )

                    val password = viewModel.password.value.collectAsState()
                    PasswordField(
                        label = "Password",
                        textState = password.value,
                        onValueChange = { viewModel.password.setValue(it) }
                    )
                }

                Row(modifier = Modifier
                    .padding(top = 20.dp)
                    .width(328.dp),
                    horizontalArrangement = Arrangement.SpaceBetween) {

                    StandardButton(text = "Registration") {
                        navigator.push(RegistrationScreen())
                    }

                    StandardButton {
                        viewModel.login()
                    }

                }
            }

        }
    }
}