package com.eliza.wfx.dal

import com.eliza.wfx.model.MeiPaiModel
import org.junit.Test


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/8/21
 * @Software: IntelliJ IDEA
 */
class UserKtTest {
    @Test
    fun ds() {
        val mm = MeiPaiModel(12, 34, "WER")
        mm.ownerId = 23
        mm.getnCollect()

    }

    @Test
    fun sd() {
        var args = arrayOf(1, 2, 3, 4, 5)

        for (i in 0..args.size step (2)) {
            println(i)
        }

    }


}