package com.team4event.eventsapp.network.events

import com.team4event.eventsapp.consts.URLs
import com.team4event.eventsapp.datamodels.event.Event
import com.team4event.eventsapp.datamodels.user.AuthToken
import com.team4event.eventsapp.datamodels.user.UserLogin
import com.team4event.eventsapp.datamodels.user.UserRegistry
import com.team4event.eventsapp.network.httpClient
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import java.util.logging.Logger

class EventsRepository(private val client: HttpClient = httpClient, private val token: String) {
    private val logger = Logger.getLogger("EventsRepository")

    suspend fun getEvents(): List<Event>?{

        logger.info("getEvents")
        val a = client.get(URLs.events){
            headers {
                append("Authorization", "Token $token")
            }
        }

        logger.info(a.bodyAsText())
        logger.info(a.status.toString())

        if (a.status.value in 200..299){
            return Json.decodeFromString<List<Event>>(a.bodyAsText())
        }

        return null
    }

}
