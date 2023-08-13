package com.team4event.eventsapp.network.auth

import com.team4event.eventsapp.consts.URLs
import com.team4event.eventsapp.datamodels.user.AuthToken
import com.team4event.eventsapp.datamodels.user.UserLogin
import com.team4event.eventsapp.datamodels.user.UserRegistry
import com.team4event.eventsapp.network.httpClient
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import java.util.logging.Logger

class AuthRepository(private val client: HttpClient = httpClient) {
    private val logger = Logger.getLogger("AuthRepository")

    suspend fun login(login: String, password: String): String?{
        val a = client.post(URLs.login){
            setBody(
                UserLogin(
                    username = login,
                    password = password
                )
            )
        }

        logger.info(a.bodyAsText())

        if (a.status.value in 200..299){
            return Json.decodeFromString<AuthToken>(a.bodyAsText()).authToken
        }

        return null
    }

    suspend fun register(login: String, password: String, email: String): String?{
        val a = client.post(URLs.register){
            setBody(
                UserRegistry(
                    username = login,
                    mail = email,
                    password = password
                )
            )
        }
            .status.value

        if (a in 200..299){
            return login(login, password)
        }

        return null
    }
}