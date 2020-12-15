package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RegistrationValidator {
    val test = UserDB()
    var user = UserData()
    val Alluser = arrayListOf<UserData>()
    fun userdata(){
        user.Name = "Andrew"
        user.Password = "123113221"
        user.Email = "asd@mail.ru"
        user.Phone = "37015236854"
        user.Surname = "ANDNDas"
        user.Username = "Andrew"
        Alluser.add(user)

    }
    @Test
    fun checkIfPasswordIsValidate_When_Two_Passwords_The_Same_Test(){
        assertEquals(true, test.checkIfPasswordIsValidate("123456789", "123456789"))
    }
    @Test
    fun checkIfPasswordIsValidate_When_Two_Passwords_Not_The_Same_Test(){
        assertEquals(false, test.checkIfPasswordIsValidate("12345678", "123456789"))
    }
    @Test
    fun checkIfPasswordIsValidate_When_Two_Passwords_Not_The_Same_Test2(){
        assertEquals(false, test.checkIfPasswordIsValidate("123456789", "12345678"))
    }
    @Test
    fun checkIfUsernameExists_When_Username_Exist(){
        userdata()
        assertEquals(false, test.checkIfUsernameExists("Andrew", Alluser ))
    }
    @Test
    fun checkIfUsernameExists_When_Username_Not_Exist2(){
        userdata()
        assertEquals(true, test.checkIfUsernameExists("John", Alluser ))
    }
    @Test
    fun checkIfUsernameExists2_When_Username_Not_Exist(){
        userdata()
        assertEquals(user, test.checkIfUsernameExists2("John", Alluser ))
    }
    @Test
    fun checkIfPasswordExists_When_Password_Is_Correct(){
        userdata()
        user.Password = test.hash("a")
        assertEquals(false, test.checkIfPasswordExists("a", Alluser ))
    }
    @Test
    fun checkIfEmailExists_When_Email_Exist(){
        userdata()
        assertEquals(false, test.checkIfEmailExists("asd@mail.ru", Alluser ))
    }
    @Test
    fun checkIfEmailExists_When_Email_Not_Exist(){
        userdata()
        assertEquals(true, test.checkIfEmailExists("asdasdasd@mail.ru", Alluser ))
    }
    @Test
    fun checkIfPhoneExists_When_Phone_Exist(){
        userdata()
        assertEquals(false, test.checkIfPhoneExists("37015236854", Alluser ))
    }
    @Test
    fun checkIfPhoneExists_When_Phone_Not_Exist(){
        userdata()
        assertEquals(true, test.checkIfPhoneExists("37015236852", Alluser ))
    }
    @Test
    fun Check_If_hashing_working_Ok(){
        assertEquals("ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb", test.hash("a" ))
    }

//    @Test
//    fun checkIfPhoneIsValidate_Test(){
//        assertEquals(true, test.checkIfPhoneIsValidate("37054826983"))
//    }

}
