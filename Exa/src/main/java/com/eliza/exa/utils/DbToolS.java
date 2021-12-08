package com.eliza.exa.utils;

import com.eliza.exa.utils.JDBC.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 11/12/21
 * @Software: IntelliJ IDEA
 */
public class DbToolS {
    private static Connection conn = null;

    static ResultSet rs = null;

    static {
        conn = new JDBC().getConn();
        System.out.println(conn);
    }

    public static Connection getConn() {

        return conn;
    }

    /**
     * @param sql 增刪改
     * @return 数据改动
     */
    public static int addUpdDel(String sql) {
        int i = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql数据库增删改异常");
            e.printStackTrace();
        }

        return i;
    }

    /**
     * @param sql 查詢
     * @return 查询结果
     */
    public static ResultSet selectSql(String sql) {
        try {
            rs = conn.prepareStatement(sql).executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("sql数据库查询异常");
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 關閉數據庫
     */
    public static void closeConn() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("sql数据库关闭异常");
            e.printStackTrace();
        }

    }
}
