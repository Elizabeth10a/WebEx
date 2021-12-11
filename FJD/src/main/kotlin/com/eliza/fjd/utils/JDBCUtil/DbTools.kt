package com.eliza.fjd.utils.JDBCUtil

import com.eliza.fjd.utils.JDBCUtils
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException


/*-*- coding:utf-8 -*-
'?.' '?:' '!!' 'as?' '?'


?. 不为空执行后面的，否则返回null
？: 不为空 返回前面，为空执行后面
as? 是后面的类型 ，不是返回null
!! ；  !null 返回本身，空指针报错

@Nullable+Type→Type?
@NotNull+Type>Type


 */
class DbTools {
    //静态方法
    companion object {
        private var conn: Connection? = null
        private var rs: ResultSet? = null

        init {
            conn = (JDBCUtils().getConn() ?: print(conn)) as Connection?
            println("init链接")
        }

        /**
         * @param sql 增刪改
         * @return 数据改动
         */
        fun addUpdDel(sql: String): Int {
            var i = 0
            try {
                val ps = conn?.prepareStatement(sql);
                i = ps!!.executeUpdate();
            } catch (e: SQLException) {
                println("sql数据库增删改异常");
                e.printStackTrace();
            }
            return i

        }

        /**
         * @param sql 查詢
         * @return 查询结果
         */
        fun selectSql(sql: String): ResultSet? {
            println("selectSql链接")
            try {
                rs = conn?.prepareStatement(sql)?.executeQuery(sql);
            } catch (e: SQLException) {
                println("sql数据库查询异常");
                e.printStackTrace();
            }
            return rs
        }

        fun closeConn() {
            try {
                conn?.close()
            } catch (e: SQLException) {
                System.out.println("sql数据库关闭异常");
                e.printStackTrace();
            }
        }
    }
}