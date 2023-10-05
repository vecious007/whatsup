package org.acad.domain.repo

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

/**
 * Created by Acad Bek on 10/6/2023.
 */
interface SettingsRepo {
    fun onBoarded() : Completable
    fun getOnBoarded(): Single<Boolean>
}