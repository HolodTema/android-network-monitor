package com.terabyte.domain.usecase

import com.terabyte.domain.model.SettingsModel
import com.terabyte.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetSettingsUseCase @Inject constructor(private val settingsRepository: SettingsRepository) {

    operator fun invoke(): Flow<SettingsModel> {
        return settingsRepository.flowSettingsModel
    }

}