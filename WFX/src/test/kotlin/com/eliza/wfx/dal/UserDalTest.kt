package com.eliza.wfx.dal

import com.eliza.wfx.dal.UserDal
import com.eliza.wfx.model.UserModel
import org.junit.jupiter.api.Test


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/7/21
 * @Software: IntelliJ IDEA
 */
class UserDalTest {
    @Test
    fun getUserAllTest() {

        val dal = UserDal()
        var v = "css"
        val userAll = dal.getUserAll("w_user", "u_", "name=$v", "title=asssd")
        if (userAll != null) {
            for (user in userAll) {
                println(user.toString())

            }
        }

    }

    @Test
    fun getUserString() {

        var ass = "12=12=23"
        println(ass.subSequence(0, ass.indexOf("=")))
        println(ass.subSequence(ass.indexOf("=") + 1, ass.length))
        println(ass.split("=").size)
        ass = "=12"

        println(ass.subSequence(0, ass.indexOf("=")))
        println(ass.subSequence(ass.indexOf("=") + 1, ass.length))

        for (v in ass.split("="))
            println("l:" + v)

    }


}