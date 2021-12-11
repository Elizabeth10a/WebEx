package com.eliza.wfx.dal

import com.eliza.wfx.model.MeiPaiModel
import com.eliza.wfx.model.UserModel
import org.junit.Test
import kotlin.reflect.full.declaredMembers
import kotlin.reflect.full.memberProperties

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/8/21
 * @Software: IntelliJ IDEA
 */
class MeiTieDalTest {
    val meiTieDal = MeiTieDal()
    val meiPaiModel = MeiPaiModel()


    @Test
    fun getMeiTieAllTest() {
        val meiTieAll = meiTieDal.getMeiTieAll()
        meiTieAll?.let {
            for (value in meiTieAll) {
                println(value.id.toString() + ":" + value.content)
                println(value.owner)
            }
        }

    }

    @Test
    fun deleteMeiTie() {
        println(meiTieDal.deleteMeiTie(12))
    }

    @Test
    fun reflectTest() {
        println(::MeiTieDal.name)
        println(MeiPaiModel::class.constructors)
        println(MeiPaiModel::class.decl aredMembers)
        println(MeiPaiModel::class.memberProperties)
        val mes = MeiPaiModel::class.memberProperties
        for (v in mes) {
            println(v.name)
        }
    }

    @Test
    fun updateUser() {

        meiTieDal.updateMeiTie(MeiPaiModel(22, 12, "meinv"), "id", id = 12)
    }

    @Test

    fun nameToMethodTest() {
        NameToMethod<MeiPaiModel>(meiPaiModel).asd()
    }
}