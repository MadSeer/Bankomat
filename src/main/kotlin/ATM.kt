import extensions.checkLogin
import extensions.checkPassword
import extensions.getModel
import extensions.readAndConvertToDouble
import model.Constants.MMM1
import model.Constants.MMM50
import model.User
import model.Users

class ATM(val users: Users) {

    var currentUser = User()

    fun login(): Boolean {
        println("Input login")
        val inputLogin: String = readln()
        println("Input password")
        val inputPassword: String = readln()
        return if (inputLogin == users.checkLogin(users, inputLogin) && inputPassword == users.checkPassword(
                users,
                inputPassword
            )
        ) {
            currentUser = users.getModel(users, inputLogin)!!
            println("Authorisation successful")
            true
        } else {
            println("Authorisation failed")
            false
        }
    }

    fun cashIn() = cashOperation(Operation.CASH_IN)
    fun cashOut() = cashOperation(Operation.CASH_OUT)
    fun cashSend() = cashOperation(Operation.CASH_SEND)
    fun displayMoney() = println("You have ${currentUser.money}")

    private fun cashOperation(operation: Operation) = try {
        println("How much money do you want to contribute?")
        val money = 0.0.readAndConvertToDouble()
        when (operation) {
            Operation.CASH_IN -> {
                if (money % MMM1 == 0.0) {
                    currentUser.money += money
                    println("$money MMM tickets contributed")
                } else {
                    println("The amount must be a multiple of $MMM1")
                }
            }

            Operation.CASH_OUT -> {
                if (money > currentUser.money) println("Ti bomj ebaniy")
                else if (money % MMM50 == 0.0) {
                    currentUser.money -= money
                    println("$money MMM tickets contributed")
                } else {
                    println("The amount must be a multiple of $MMM50")
                }
            }

            Operation.CASH_SEND -> {
                if (money > currentUser.money) println("Ti bomj ebaniy")
                else {
                    println("Komu pepeslat dengi?")
                    val recipient = readln()
                    if (recipient == users.checkLogin(users, recipient)) {
                        currentUser.money -= money
                        users.getModel(users, recipient)!!.money += money
                    } else {
                        println("User is not exist")
                    }
                }
            }
        }
    } catch (e: Exception) {
        println("Error")
    }

    private enum class Operation {
        CASH_IN,
        CASH_OUT,
        CASH_SEND
    }
}


