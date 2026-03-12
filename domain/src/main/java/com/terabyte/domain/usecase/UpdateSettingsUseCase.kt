package com.terabyte.domain.usecase

import com.terabyte.domain.repository.SettingsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UpdateSettingsUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {

    suspend fun updateDarkTheme(darkTheme: Boolean) {
        settingsRepository.updateDarkTheme(darkTheme)
    }

    suspend fun updateLanguage(language: String) {
        settingsRepository.updateLanguage(language)
    }

    suspend fun updateMonitorStartTimeMills(mills: Long) {
        settingsRepository.updateMonitorStartTimeMills(mills)
    }

    suspend fun updateIsMonitorWorking(isWorking: Boolean) {
        settingsRepository.updateIsMonitorWorking(isWorking)
    }
}