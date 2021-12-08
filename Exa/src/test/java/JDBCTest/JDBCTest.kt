package JDBCTest

import com.eliza.exa.utils.JDBC.JDBC
import org.junit.jupiter.api.Test
import java.sql.ResultSet


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/5/21
 * @Software: IntelliJ IDEA
 */

class JDBCTest {
    var rs: ResultSet? = null

    @Test
    fun conn() {
        val conn = JDBC().getConn()
        println(conn)
        val sql = "select * from WFX.W_user"
        if (conn != null) {
            rs = conn.prepareStatement(sql).executeQuery()
            println(rs)
            if (rs != null) {
                while (rs!!.next()) {
                    println(rs!!.getString("u_id") + rs!!.getString("u_name"))
                }
            }
        } else {
            println("链接出错")
        }


    }
}