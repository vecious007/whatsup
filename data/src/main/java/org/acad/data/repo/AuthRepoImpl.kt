package org.acad.data.repo

import org.acad.data.remote.auth.AuthFirebase
import org.acad.domain.repo.AuthRepo

/**
 * Created by Acad Bek on 9/13/2023.
 */
class AuthRepoImpl constructor(
    private val authFirebase: AuthFirebase
) : AuthRepo {
    override fun sendSmsCode(phone: String) {
        authFirebase.sendSmsCode(phone)
    }
}