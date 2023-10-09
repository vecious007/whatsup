package org.acad.data.local.settings

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

/**
 * Created by Acad Bek on 10/5/2023.
 */
class SettingsRealm : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId.create()
    var onBoarded: Boolean = false
}
