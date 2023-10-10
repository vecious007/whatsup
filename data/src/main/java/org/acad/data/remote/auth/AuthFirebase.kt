package org.acad.data.remote.auth

import io.reactivex.rxjava3.core.Completable

/**
 * Created by Acad Bek on 9/13/2023.
 */
interface AuthFirebase {
    fun sendSmsCode(phone: String) : Completable
    fun verify(code: String) : Completable
}