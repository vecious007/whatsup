package org.acad.data.remote.auth

/**
 * Created by Acad Bek on 9/13/2023.
 */
interface AuthFirebase {
    fun sendSmsCode(phone: String)
}