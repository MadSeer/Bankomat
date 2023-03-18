import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import model.UserRealModel

suspend fun main(args: Array<String>) {
    val config = RealmConfiguration.create(schema = setOf(UserRealModel::class))
    val realm: Realm = Realm.open(config)
    val menu = Menu(realm)
    menu.openMenu()
    //var konfig = RealmConfiguration
}