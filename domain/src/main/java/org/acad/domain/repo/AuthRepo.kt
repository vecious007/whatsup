package org.acad.domain.repo

/**
 * Created by Acad Bek on 9/13/2023.
 */
interface AuthRepo {
    fun sendSmsCode(phone: String)
}