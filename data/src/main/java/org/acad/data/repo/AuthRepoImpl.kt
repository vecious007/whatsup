package org.acad.data.repo

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.acad.data.remote.auth.AuthFirebase
import org.acad.domain.repo.AuthRepo

/**
 * Created by Acad Bek on 9/13/2023.
 */
class AuthRepoImpl constructor(
    private val authFirebase: AuthFirebase
) : AuthRepo {
    override fun sendSmsCode(phone: String): Completable = authFirebase.sendSmsCode(phone)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    override fun verify(code: String): Completable = authFirebase.verify(code)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}