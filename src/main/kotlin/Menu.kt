import model.Users

class Menu() {
    private var users = Users()
    private val atm = ATM(users)


    fun openMenu(){
        var exit = false
        while (!exit) {
            println(
                """
            1. Registration
            2. Authorisation
            3. *debug* Add sample
            4. *debug* User List
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