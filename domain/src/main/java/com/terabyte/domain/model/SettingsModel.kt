package com.terabyte.domain.model

data class SettingsModel(
    val isMonitorWorking: Boolean,
    val monitorStartTimeMills: Long,
    val darkTheme: Boolean,
    val language: String
)