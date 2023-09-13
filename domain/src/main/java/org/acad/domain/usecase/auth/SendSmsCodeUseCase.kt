package org.acad.domain.usecase.auth

import org.acad.domain.repo.AuthRepo

/**
 * Created by Acad Bek on 9/13/2023.
 */
class SendSmsCodeUseCase constructor(
    private val authRepo: AuthRepo
) {
    operator fun invoke(phone: String) {
        authRepo.sendSmsCode(phone)
    }
}