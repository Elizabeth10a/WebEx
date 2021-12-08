package com.eliza.exa.utils.JDBC

import com.alibaba.druid.pool.DruidDataSource
import com.alibaba.druid.pool.DruidDataSourceFactory
import com.alibaba.druid.pool.DruidPooledConnection
import java.util.*


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/5/21
 * @Software: IntelliJ IDEA
 */
class JDBC {
    var dataSource: DruidDataSource? = null

    init {
        //1.从类路径下加载配置文件，获取一个输入流。如果不指定路径，默认是读取同一个包下资源文件
        val ist = JDBC::class.java.getResourceAsStream("/db/sql.properties");
        //2.使用Properties对象的方法将配置文件中属性加载到Properties对象中
        val properties = Properties()
        properties.load(ist) //加载了配置文件中所有的属性
        dataSource = (DruidDataSourceFactory.createDataSource(properties) as DruidDataSource?)!!
        if (dataSource == null) {
            println("链接出错!")
        }


    }

    fun getConn(): DruidPooledConnection? {
        //3.通过druid的工厂类创建连接池
        if (this.dataSource == null) {
            println("创建链接出错。。。")
            return null
        }
        val conn = this.dataSource?.getConnection()
        if (conn == null) {
            println("创建链接对象出错。。。")
            return null
        }
        return conn

    }
}