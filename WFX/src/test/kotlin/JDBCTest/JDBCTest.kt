import com.eliza.wfx.utils.JDBCUtils
import org.junit.jupiter.api.Test
import java.sql.ResultSet
import java.sql.SQLException


class JDBCTest {
    var rs: ResultSet? = null

    @Test
    fun conn() {
        val conn = JDBCUtils().getConn()
        val sql = "select * from WFX.W_user"
        if (conn != null) {
            conn.prepareStatement(sql).executeQuery().also { rs = it }
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

    @Test
    fun DbToolsTestAdd() {
        rs = DbTools.selectSql("SELECT 1 FROM W_user where u_id= '12'  limit 1;");
        var flag: Boolean = false
        try {
            println("count:" + (rs?.first()));

            if (rs?.first() == true) {
                val sql = "select * from WFX.W_user"
                val i = DbTools.addUpdDel(sql);
                if (i > 0) {
                    flag = true;
                }
            } else {
                println("--不存在数据请添加---");

            }
        } catch (e: SQLException) {
            e.printStackTrace();
        }

    }

    //kotlin
    @Test
    fun DbToolsTestSele() {
        try {
            rs = DbTools.selectSql("select * from W_user where u_name =" + "\'se\'")
            println("rs")
            println(rs)
            rs?.let {
                println("it:" + it)
                while (it.next()) {
                    if (it.getString("u_name").equals("ew")) {
                        println("信息存在")
                    } else {
                        println("不存在")
                    }
                }
            }
        } catch (e: SQLException) {
            e.printStackTrace();
        }

    }
}


