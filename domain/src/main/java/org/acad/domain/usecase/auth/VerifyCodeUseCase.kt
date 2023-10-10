package org.acad.domain.usecase.auth

import org.acad.domain.repo.AuthRepo

/**
 * Created by Acad Bek on 9/13/2023.
 */
class VerifyCodeUseCase(
    private val authRepo: AuthRepo
) {
    operator fun invoke(code: String) = authRepo.verify(code)

}