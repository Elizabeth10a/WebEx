package com.eliza.wfx.dal

import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.declaredMembers
import kotlin.reflect.full.memberFunctions


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/10/21
 * @Software: IntelliJ IDEA
 */
class NameToMethod<T>(v: T) {
    var v: T? = null

    init {
        this.v = v

    }

    fun asd() {
        this.v?.let {
            println(v)
            if (!v!!::class.members.isEmpty()) {
                println(v!!::class.members.toString())//所有
                println(v!!::class.declaredMembers)//仅自定
                println(v!!::class.memberFunctions.toString())

                println(v!!::class::declaredFunctions.toString())
            }
        }
    }

    fun aadsa() {

        println(v)
    }
}