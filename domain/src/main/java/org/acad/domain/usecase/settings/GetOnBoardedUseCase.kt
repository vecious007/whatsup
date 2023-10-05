package org.acad.domain.usecase.settings

import org.acad.domain.repo.SettingsRepo

/**
 * Created by Acad Bek on 10/6/2023.
 */
class GetOnBoardedUseCase(
    private val settingsRepo: SettingsRepo
) {

    operator fun invoke() = settingsRepo.getOnBoarded()
}