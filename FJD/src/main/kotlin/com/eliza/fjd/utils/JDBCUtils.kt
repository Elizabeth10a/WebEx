package com.eliza.fjd.utils

import com.alibaba.druid.pool.DruidDataSource
import com.alibaba.druid.pool.DruidDataSourceFactory
import com.alibaba.druid.pool.DruidPooledConnection
import java.util.*

class JDBCUtils {
    var ds: DruidDataSource? = null

    init {
        val properties = Properties()
        properties.load(JDBCUtils::class.java.getResourceAsStream("/db/sql.properties")) //加载了配置文件中所有的属性
        ds = (DruidDataSourceFactory.createDataSource(properties) as DruidDataSource?)
        ds ?: let {
            println("链接池创建出错!")
            return@let
        }
    }

    fun getConn(): DruidPooledConnection? {
        this.ds ?: let {
            println("创建链接出错。。。")
            return null

        }

        val conn = this.ds?.connection ?: let {
            println("创建链接对象出错。。。")
            return null
        }

        return conn

    }
}