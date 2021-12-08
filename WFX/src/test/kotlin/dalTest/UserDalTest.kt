package dalTest

import com.eliza.wfx.dal.UserDal
import com.eliza.wfx.model.UserModel
import org.junit.jupiter.api.Test


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/7/21
 * @Software: IntelliJ IDEA
 */
class UserDalTest {
    @Test
    fun getUserAllTest() {

        val dal = UserDal()
        val userAll = dal.getUserAll("w_user","u_id","12")
        if (userAll != null) {
            for (user in userAll) {
                println(user.toString())

            }
        }

    }
}