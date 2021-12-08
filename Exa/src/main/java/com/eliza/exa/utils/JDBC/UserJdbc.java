package com.eliza.exa.utils.JDBC;


import com.eliza.exa.utils.DbToolS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 11/12/21
 * @Software: IntelliJ IDEA
 */
public class UserJdbc {
    public boolean register(UserModel user) throws SQLException {
        boolean flag = false;
        /**/
        int i = DbToolS.addUpdDel("insert into user(u_id,u_name,u_pwd ) " +
                "values(" + user.getId() + "'" + user.getUserName() + "'" + user.getPwd());
        if (i > 0) {
            flag = true;
        }
        return flag;
    }


    public UserModel login(String name, String pwd) {
        try {
            ResultSet rs = DbToolS.selectSql("select * from UserModel where u_name='" + name + "' and u_name='" + pwd + "'");
            while (rs.next()) {
                if (rs.getString("u_name").equals(name) && rs.getString("u_psw").equals(pwd)) {
                    return new UserModel(rs.getInt("u_id"), name, pwd);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @return 获取 所有user实例的列表 ,或一个
     */
    public List<UserModel> getUserAll(String... args) {
        String sql = "select * from UserModel";
        if (!("".equals(args[0]) || "*".equals(args[0]))) {//如果不是 *
            sql += " where " + args[0] + "='" + args[1] + "'";
            System.out.println(sql);
        }
        List<UserModel> list = new ArrayList<UserModel>();
        try {
            ResultSet rs = DbToolS.selectSql(sql);
            while (rs.next()) {
           /*     UserModel userModel = new UserModel(rs.getInt("u_id"),
                        rs.getString("u_name"),
                        rs.getString("u_pwd"));*/
                list.add(new UserModel(rs.getInt("u_id"),
                        rs.getString("u_name"),
                        rs.getString("u_pwd")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param user 实例，通过 id 判断是否存在，若存在则修改，不存在提示错误
     * @return 是否修改成功
     */
    public boolean updateUser(UserModel user) {

        ResultSet rs = DbToolS.selectSql("SELECT 1 FROM UserModel where u_id=" + user.getId() + "  limit 1;");
        boolean flag = false;

        try {
            System.out.println("count:" + rs.first());
            if (rs.first()) {
                String sql = "update UserModel set " +
                        "u_name='" + user.getUserName() +
                        "',u_pwd='" + user.getPwd() +
                        "' where u_id =" + user.getId();

                int i = DbToolS.addUpdDel(sql);
                if (i > 0) {
                    flag = true;
                }
            } else {
                System.out.println("--不存在数据请添加---");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return flag;
    }

    /**
     * @param u_id 通过 user的id
     * @return 是否删除成功
     */
    public boolean deleteUser(int u_id) {
        boolean flag = false;
        String sql = "delete  from UserModel where u_id=" + u_id;
        int i = DbToolS.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        return flag;
    }

}
