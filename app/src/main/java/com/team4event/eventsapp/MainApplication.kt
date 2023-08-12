package com.team4event.eventsapp

import android.app.Application
import ru.dgis.sdk.Context
import ru.dgis.sdk.DGis
import ru.dgis.sdk.HttpOptions
import ru.dgis.sdk.LogLevel
import ru.dgis.sdk.LogOptions
import ru.dgis.sdk.PersonalDataCollectionConsent

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        appContext = this.applicationContext

        // Настройки журналирования
        val logOptions = LogOptions(
            LogLevel.VERBOSE
        )

        // Настройки HTTP-клиента
        val httpOptions = HttpOptions(
            useCache = false
        )

        // Согласие на сбор и отправку персональных данных
        val dataCollectConsent = PersonalDataCollectionConsent.GRANTED

        sdkContext = DGis.initialize(
            appContext = this,
            dataCollectConsent = dataCollectConsent,
            logOptions = logOptions,
            httpOptions = httpOptions
        )

    }

    companion object{
        lateinit var appContext: android.content.Context
        lateinit var sdkContext: Context
    }
}