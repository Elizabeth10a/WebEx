package com.eliza.wfx.dal;

import com.eliza.wfx.model.UserModel;
import org.junit.Test;

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/10/21
 * @Software: IntelliJ IDEA
 */
public class Tesxt1 {
    private UserDal ud = new UserDal();

    @Test
    void AS() {
        ud.getUserAll("", "sa", "sa");
    }
}
