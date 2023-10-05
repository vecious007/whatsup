package org.acad.data.local.settings

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

/**
 * Created by Acad Bek on 10/5/2023.
 */
data class SettingsRealm(
    @PrimaryKey
    val id: ObjectId = ObjectId.create(),
    val onBoarded: Boolean = false
) : RealmObject
