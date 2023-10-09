package org.acad.data.local.settings

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query

/**
 * Created by Acad Bek on 10/5/2023.
 */
class SettingsStorageImpl(
    private val realm: Realm
) : SettingsStorage {
    private fun getSettings(): Single<SettingsRealm> = Single.fromCallable {
        realm.query<SettingsRealm>().find().firstOrNull() ?: run {
            realm.writeBlocking {
                copyToRealm(SettingsRealm())
            }
        }
    }

    override fun onBoarded(): Completable = getSettings().flatMapCompletable {
        Completable.fromCallable {
            realm.writeBlocking {
                copyToRealm(it.apply{ onBoarded = true }, UpdatePolicy.ALL)
            }
        }
    }

    override fun getOnBoarded(): Single<Boolean> = getSettings().map { it.onBoarded }
}