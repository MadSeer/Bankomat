package extensions
import model.Users

fun Users.checkLogin(users: Users, inputLogin: String) = users.getUsersList().find { it.login == inputLogin }?.login
fun Users.checkPassword(users: Users, inputPassword: String) = users.getUsersList().find { it.password == inputPassword }?.password
fun Users.checkMoney(users: Users, money: Double) = users.getUsersList().find { it.money == money }?.money
fun Users.getModel(users: Users,inputLogin: String) = users.getUsersList().find { it.login == inputLogin }

fun String.tochlen(hello: ()->Unit)=this.replace("x", "y")