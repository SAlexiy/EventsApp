package com.team4event.eventsapp.datamodels.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthToken(
    @SerialName("auth_token")
    val authToken: String
)
// e30f908901bdd3be6cfb469bf48f8a9b7f119076