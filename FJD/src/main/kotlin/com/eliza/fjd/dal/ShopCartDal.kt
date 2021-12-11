package com.eliza.fjd.dal

import com.eliza.fjd.utils.JDBCUtil.DbTools
import java.sql.SQLException


/**
 *  购物车信息 增删
 *  f_commodity  商品表
 *  f_user  用户表
 * @constructor Create empty Shop cart dal
 */
class ShopCartDal {
    fun addShopCart(u_id: Int, c_id: Int): Boolean {
        var flag = false
        var sql = "insert into f_shopcart (s_u_id, s_c_id) values"
        var u_rs = DbTools.selectSql("SELECT 1 FROM f_user where u_id=${u_id} limit 1")
        var c_rs = DbTools.selectSql("SELECT 1 FROM f_commodity where c_id=${c_id} limit 1")

        //如果存在该用户和商品

        if (u_rs?.first()!! && c_rs?.first()!!) {
            sql += "$u_id ,${c_id} "
        } else {
            return flag
        }
        try {
            val i = DbTools.addUpdDel(sql)
            if (i > 0) {
                flag = true
            }
            return flag
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return flag

    }

    fun getAll(u_id: Int): MutableList<ShopCartDal>? {
        var sql = "select * from w_user"
        val list: MutableList<ShopCartDal> = ArrayList()
        try {
            val rs = DbTools.selectSql(sql)
            while (rs!!.next()) {
                CommodityDal().getCommodityAll()
            }

            if (list.isEmpty()) {
                println("--信息不存在--")
                return null
            }
            return list
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return null

    }

    fun delete(u_id: Int): Boolean {
        var flag = false
        val sql = "delete  from UserModel where u_id=$u_id"
        val i = DbTools.addUpdDel(sql)
        if (i > 0) {
            flag = true
        }
        return flag
    }

}