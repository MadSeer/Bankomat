package model

import UserSample

class Users{
    private var users = mutableListOf<User>()

    fun addUserSample(){
        val sample = UserSample()
        val user = User()
        user.login = sample.login
        user.password = sample.password
        user.money = sample.money
        users.add(user)
    }

    fun createNewUser(){
        val user = User()
        println("Enter login")
        user.login = readln()
        println("Enter password")
        user.password = readln()
        users.add(user)
    }

    fun getUsersList():MutableList<User>{
        return users
    }


}