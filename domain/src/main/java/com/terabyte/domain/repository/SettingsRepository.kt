package com.terabyte.domain.repository

import com.terabyte.domain.model.SettingsModel
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    val flowSettingsModel: Flow<SettingsModel>

    suspend fun updateDarkTheme(darkTheme: Boolean)

    suspend fun updateLanguage(language: String)

    suspend fun updateMonitorStartTimeMills(mills: Long)

    suspend fun updateIsMonitorWorking(isWorking: Boolean)
}