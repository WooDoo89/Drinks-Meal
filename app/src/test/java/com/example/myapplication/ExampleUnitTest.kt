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
//    @Test
//    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
//        val emailInput = "easd@mail.ru"
//        assertEquals(true, test.checkIfEmailIsValidate(emailInput))
//    }
    @Test
    fun checkIfPasswordIsValidate_Test(){
        assertEquals(true, test.checkIfPasswordIsValidate("123456789", "123456789"))
    }
//    @Test
//    fun checkIfPhoneIsValidate_Test(){
//        assertEquals(true, test.checkIfPhoneIsValidate("37054826983"))
//    }
}