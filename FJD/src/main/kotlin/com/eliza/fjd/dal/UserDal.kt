package com.eliza.fjd.dal

import com.eliza.fjd.model.UserModel
import com.eliza.fjd.utils.JDBCUtil.DbTools
import com.eliza.fjd.utils.JDBCUtil.DbTools.Companion.addUpdDel
import com.eliza.fjd.utils.JDBCUtil.DbTools.Companion.selectSql
import java.sql.ResultSet
import java.sql.SQLException


class UserDal {


    fun login(name: String, pwd: String): UserModel? {
        try {
            val rs: ResultSet? = DbTools.selectSql("select * from w_user where u_name='$name' and u_pwd='$pwd'")
            while (rs?.next() == true) {
                if (rs.getString("u_name") == name && rs.getString("u_psw") == pwd) {
                    return UserModel(name, pwd )
                }
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return null

    }
    @Throws(SQLException::class)
    fun register(user: UserModel): Boolean {
        var flag = false
        /**/
        val i =
            addUpdDel("insert into w_user(u_id,u_name,u_pwd ) values('${user.id}' ,'${user.name}' , '${user.pwd}') ")
        if (i > 0) {
            flag = true
        }
        return flag
    }
    /**
     * Get user all
     *
     * @param tableName 表名,默认从 w_user读取
     * @param args  不定参数,两两匹配["属性=值","属性=值"]
     * @return
     */
    fun getUserAll(tableName: String? = null, front: String, vararg args: String): List<UserModel>? {
        var sql = "select * from w_user"
        if (args.isNotEmpty()) {

            val map = HashMap<String, String>()
            for (v in args) {
                if (v.indexOf("=") < 0) {//不包含
                    map[v.subSequence(0, v.indexOf("=")).toString()] =
                        v.subSequence(v.indexOf("=") + 1, v.length).toString()
                } else {
                    println("---输入参数有误--")
                    return null
                }
            }
        }

        tableName?.let {
            sql = "select * from $tableName"
            if (args.isNotEmpty()) {
                when (args[0].split("=").size == 2) {
                    args.size == 1 -> sql =
                        "select * from $tableName where ${front}${args[0].split("=")[0]}='${args[0].split("=")[1]}' "
                    args.size > 2 -> for (i in 1..args.size) {
                        sql += "${front}${args[i].split("=")[0]}='${args[i].split("=")[1]}'"
                    }
                    else -> {
                        println("---输入参数有误--")
                    }
                }
            }

        }
        println(sql)
        val list: MutableList<UserModel> = ArrayList()
        try {
            val rs = DbTools.selectSql(sql)
            while (rs!!.next()) {
                list.add(
                    UserModel(
                        rs.getInt("u_id"),
                        rs.getString("u_name"),
                        rs.getLong("u_tel"),
                        rs.getString("u_pwd"),
                        rs.getString("u_head_img"),
                        rs.getString("u_balance"),
                        rs.getString("u_addr")
                    )
                )
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

    /**
     * @param user 实例，通过 id 判断是否存在，若存在则修改，不存在提示错误
     * @return 是否修改成功
     */
    fun updateUser(user: UserModel): Boolean {
        val rs = selectSql("SELECT 1 FROM UserModel where u_id=" + user.id + "  limit 1;")
        var flag = false
        try {
            println("count:" + rs!!.first())
            if (rs.first()) {
                val sql =
                    "update UserModel set " + "u_name='" + user.name + "',u_pwd='" + user.pwd + "' where u_id =" + user.id
                val i = addUpdDel(sql)
                if (i > 0) {
                    flag = true
                }
            } else {
                println("--不存在数据请添加---")
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return flag
    }

    /**
     * @param u_id 通过 user的id
     * @return 是否删除成功
     */
    fun deleteUser(u_id: Int): Boolean {
        var flag = false
        val sql = "delete  from UserModel where u_id=$u_id"
        val i = addUpdDel(sql)
        if (i > 0) {
            flag = true
        }
        return flag
    }
}