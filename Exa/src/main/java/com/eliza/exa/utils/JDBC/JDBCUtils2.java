package com.eliza.exa.utils.JDBC;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 11/2/21
 * @Software: IntelliJ IDEA
 */
public class JDBCUtils2 {
    private static DataSource ds;
    private static Connection conn;

    static {
        try {

            String driver = "org.mariadb.jdbc.Driver";
            //从配置参数中获取数据库url
            String url = "jdbc:mariadb://192.168.41.150:3306/Test";
            //从配置参数中获取用户名
            String user = "eliza";
            //从配置参数中获取密码
            String pass = "eliza";

            //注册驱动
            Class.forName(driver);
            //获取数据库连接
            conn = DriverManager.getConnection(url, user, pass);


            System.out.println("Success!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource() {
        return ds;
    }
    /**
     * 获取连接Connection对象
     */
    public Connection getConnection() throws SQLException {
        return conn;
    }
    /**
     * 关闭连接Connection对象
     */
    public void CloseConnection() throws SQLException {
        conn.close();
    }
}
