package com.team4event.eventsapp.datamodels.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.dgis.sdk.coordinates.Longitude

@Serializable
data class Event(
    var id: Int? = null,
    var title: String?= null,
    var type: String?= null,
    var img: String?= null,
    var description: String?= null,
    var place: String?= null,
    @SerialName("coordslat")
    var latitude: String?= null,
    @SerialName("coordslon")
    var longitude: String?= null,
    @SerialName("data")
    var data: String?= null,
    @SerialName("price")
    var price: String?= null,
    @SerialName("age")
    var age: String?= null,
    @SerialName("site_url")
    var siteUrl: String?= null,
    @SerialName("dataend")
    var dataEnd: String?= null,
    @SerialName("datastart")
    var dataStart: String?= null,
    @SerialName("reminderuser")
    var reminderUser: ArrayList<Int> = arrayListOf(),
    @SerialName("favoritevnt")
    var favoritEvnt  : ArrayList<Int> = arrayListOf()

)

