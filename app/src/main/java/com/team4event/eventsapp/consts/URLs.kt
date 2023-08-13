package com.team4event.eventsapp.consts

object URLs {
    const val base = "http://adminteam4event.pythonanywhere.com/"

    const val login = "${base}auth/token/login/"
    const val register = "${base}auth/token/login/"
    const val logout  = "${base}auth/token/logout/ "

    const val events = "${base}api/v1/events"
}