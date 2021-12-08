package com.eliza.exa.utils.JDBC;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 11/2/21
 * @Software: IntelliJ IDEA
 */
public class JDBCUtils {
    private static DataSource ds;
    private Connection conn;

    static {
        try {
            System.out.println("---最初执行--");
            Properties pro = new Properties();

            //获取src路径下的文件的方式--->ClassLoader 类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("db/druid.properties");
            String path = null;
            if (res != null) {

                path = res.getPath();
            }else {
                System.out.println("----res.getPath(); null~-----");
            }
            System.out.println(res.getPath());

            //2. 加载文件
            if (path != null) {
                pro.load(new FileReader(path));
            }else {
                System.out.println("------new FileReader(path null---");
            }


            //4. 注册驱动
            Class.forName(pro.getProperty("driver"));
            System.out.println("It works !");
            //2.初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);

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
        conn = ds.getConnection();
        return conn;
    }

    /**
     * 关闭连接Connection对象
     */
    public void CloseConnection() throws SQLException {
        conn.close();
    }

}
