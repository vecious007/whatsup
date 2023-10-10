package org.acad.domain.repo

import io.reactivex.rxjava3.core.Completable

/**
 * Created by Acad Bek on 9/13/2023.
 */
interface AuthRepo {
    fun sendSmsCode(phone: String) : Completable
    fun verify(code: String) : Completable

}