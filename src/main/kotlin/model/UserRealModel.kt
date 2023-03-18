package model

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.Index
import io.realm.kotlin.types.annotations.PrimaryKey

class UserRealModel():RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId.create()
    @Index
    var login: String = ""
    var password: String = ""
    var money: Double = 0.0
}