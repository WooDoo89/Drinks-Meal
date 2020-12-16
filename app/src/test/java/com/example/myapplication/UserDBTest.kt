package com.example.myapplication

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test

class UserDBTest : TestCase() {
    private val test = UserDB()
    private var user = UserData()
    private val Alluser = arrayListOf<UserData>()
    private fun userdata(){
        user.Name = "Andrew"
        user.Password = "123113221"
        user.Email = "asd@mail.ru"
        user.Phone = "37015236854"
        user.Surname = "ANDNDas"
        user.Username = "Andrew"
        Alluser.add(user)

    }
    fun testCheckIfPasswordIsValidate() {
        Assert.assertEquals(true, test.checkIfPasswordIsValidate("123456789", "123456789"))
    }
    @Test
    fun checkIfPasswordIsValidate_When_Two_Passwords_Not_The_Same_Test(){
        Assert.assertEquals(false, test.checkIfPasswordIsValidate("12345678", "123456789"))
    }
    @Test
    fun checkIfPasswordIsValidate_When_Two_Passwords_Not_The_Same_Test2(){
        Assert.assertEquals(false, test.checkIfPasswordIsValidate("123456789", "12345678"))
    }
    fun testCheckIfUsernameExists() {
        userdata()
        Assert.assertEquals(false, test.checkIfUsernameExists("Andrew", Alluser))
    }

    fun testCheckIfUsernameExists2() {
        userdata()
        Assert.assertEquals(user, test.checkIfUsernameExists2("Andrew", Alluser))
    }

    fun testCheckIfPasswordExists() {
        userdata()
        user.Password = test.hash("a")
        Assert.assertEquals(false, test.checkIfPasswordExists("a", Alluser))
    }

    fun testCheckIfEmailExists() {
        userdata()
        Assert.assertEquals(false, test.checkIfEmailExists("asd@mail.ru", Alluser))
    }

    fun testCheckIfPhoneExists() {
        userdata()
        Assert.assertEquals(false, test.checkIfPhoneExists("37015236854", Alluser))
    }

    fun testHash() {
        Assert.assertEquals(
            "ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb",
            test.hash("a")
        )
    }
}