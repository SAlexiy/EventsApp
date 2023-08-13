package com.team4event.eventsapp.datamodels.user

import kotlinx.serialization.Serializable

@Serializable
data class UserLogin(
    val username: String,
    val password: String
)
