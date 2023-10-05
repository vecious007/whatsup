package org.acad.data.local.settings

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

/**
 * Created by Acad Bek on 10/5/2023.
 */
interface SettingsStorage {
        fun onBoarded() : Completable
        fun getOnBoarded(): Single<Boolean>
}