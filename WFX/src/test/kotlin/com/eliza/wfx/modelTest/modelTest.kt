package com.eliza.wfx.modelTest

import com.eliza.wfx.model.UserModel
import org.junit.jupiter.api.Test


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/6/21
 * @Software: IntelliJ IDEA
 */

class ModelTest {
    @Test
    fun MeiPaiModel() {

    }

    @Test
    fun userModelTest() {
        val userModel = UserModel()
        println(userModel.toString())
        println(userModel.getId())
        println(userModel.setId(12))
        println(userModel.getId())

    }


}