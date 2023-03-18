import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import model.UserRealModel
import model.Users

class Menu(var realm: Realm) {
    private var users = Users()
    private val atm = ATM(users)


    suspend fun openMenu(){
        var exit = false
        while (!exit) {
            println(
                """
            1. Registration
            2. Authorisation
            3. *debug* Add sample
            4. *debug* User List
            5. *debug* Put sample to database
            6. *debug* DB user list
            7. *debug* purge DB
            0. Exit
        """.trimIndent()
            )

            val userMenu = readln()
            when (userMenu) {
                "1" -> users.createNewUser()
                "2" -> authorisation()
                "3" -> users.addUserSample()
                "4" -> users.getUsersList().forEach {
                    println("${it.login} ${it.password} ${it.money}")
                }
                "5" -> {
                    realm.writeBlocking {
                        copyToRealm(UserRealModel().apply {
                            login = "Realm Login"
                            password = "Realm Password"
                            money = 20000.0
                        })
                    }
                }
                "6" -> {
                    val dbtest: RealmResults<UserRealModel> =
                        realm.query<UserRealModel>().find()
                    dbtest.forEach{
                        println("${it.login} ${it.password} ${it.money}")
                    }
                }
                "7" -> realm.write{
                    val dbtest: RealmResults<UserRealModel> =
                        this.query<UserRealModel>().find()
                    delete(dbtest)
                }
                "0" -> exit = true
            }
        }
    }

    private fun authorisation() {
        var authorisationMenu = atm.login()
        while (authorisationMenu) {
            println(
                """
            1. Check balance
            2. Cash in
            3. Cash Out
            4. Cash Send
            0. Exit
        """.trimIndent()
            )

            val menu = readln()
            when (menu) {
                "1" -> atm.displayMoney()
                "2" -> atm.cashIn()
                "3" -> atm.cashOut()
                "4" -> atm.cashSend()
                "0" -> authorisationMenu = false
            }
        }
    }




}