package com.team4event.eventsapp.ui.fragments.auth

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team4event.eventsapp.flow.ValueStateFlow
import com.team4event.eventsapp.network.auth.AuthRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class AuthViewModel : ViewModel() {
    val authRepository = AuthRepository()

    val login = ValueStateFlow<String>("")
    val password = ValueStateFlow<String>("")
    val email = ValueStateFlow<String>("")

    val authState = ValueStateFlow<String?>(null)


    fun login(){
        viewModelScope.launch {
            authState.setValue(runBlocking {
                authRepository.login(login.getValue(), password.getValue())
            })
        }
    }


    fun register(){
        viewModelScope.launch {
            authState.setValue(runBlocking {
                authRepository.register(login.getValue(), password.getValue(), email.getValue())
            })
        }
    }

    companion object{
        private var instance: AuthViewModel? = null

        fun getInstance(): AuthViewModel{
            if (instance == null){
                instance = AuthViewModel()
            }

            return instance!!
        }
    }



}

