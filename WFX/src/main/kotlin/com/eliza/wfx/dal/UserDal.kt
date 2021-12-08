package com.eliza.wfx.dal

import DbTools.Companion.addUpdDel
import DbTools.Companion.selectSql

import com.eliza.wfx.model.UserModel
import java.sql.ResultSet
import java.sql.SQLException


class UserDal {


    fun login(name: String, pwd: String): UserModel? {
        try {
            val rs: ResultSet? = DbTools.selectSql("select * from w_user where u_name='$name' and u_pwd='$pwd'")
            while (rs?.next() == true) {
                if (rs.getString("u_name") == name && rs.getString("u_psw") == pwd) {
                    return UserModel(name, pwd)
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
     * @param args  不定参数,两两匹配[属性,值,属性,值] 最多三对
     * @return
     */
    fun getUserAll(tableName: String? = null, vararg args: String): List<UserModel>? {
        var sql: String = "select * from w_user"
        tableName?.let {

            if (args.isNotEmpty() && args.size % 2 == 0) {
                println(tableName)

                when (args.size) {

                    2 -> sql = "select * from $tableName where ${args[0]}='${args[args.size - 1]}'"
                    4 -> sql =
                        "select * from $tableName where ${args[0]}='${args[1]}' and ${args[args.size - 2]}='${args[args.size - 1]}' "
                    6 -> sql =
                        "select * from $tableName where ${args[0]}='${args[1]}' and ${args[2]}='${args[3]}' and ${args[args.size - 2]}='${args[args.size - 1]}' "
                    else -> println("输入的参数过多,无法解析")
                }
            } else {
                println("---输入的参数有误,需重新输入--")

                println("至少输入一对 参数")
                return null
            }
        }
        println(sql)
        val list: MutableList<UserModel> = ArrayList()
        try {
            val rs = DbTools.selectSql(sql)
            while (rs!!.next()) {
                list.add(
                    UserModel(
                        rs.getLong("u_id"),
                        rs.getString("u_name"),
                        rs.getString("u_title"),
                        rs.getString("u_signature"),
                        rs.getString("u_signatureTxt"),
                        rs.getString("u_tel"),
                        rs.getString("u_pwd")
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