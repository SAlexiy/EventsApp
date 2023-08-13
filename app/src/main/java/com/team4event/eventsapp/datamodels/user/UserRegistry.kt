package com.team4event.eventsapp.datamodels.user

import kotlinx.serialization.Serializable

@Serializable
data class UserRegistry(
    val username: String,
    val mail: String,
    val password: String
)
