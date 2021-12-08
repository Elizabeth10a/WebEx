package com.eliza.wfx.servlet

import com.eliza.wfx.dal.UserDal
import com.eliza.wfx.model.MeiPaiModel
import com.eliza.wfx.model.UserModel
import com.eliza.wfx.utils.ConstantDef
import jakarta.servlet.ServletException
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.io.IOException



@WebServlet("/login")
class Login() : HttpServlet() {
    private var serialVersionUID = 1L

    constructor(serialVersionUID: Long) : this() {
        this.serialVersionUID = serialVersionUID
    }

    /**
     * @see HttpServlet.doGet
     */
    @Throws(ServletException::class, IOException::class)
    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        // TODO Auto-generated method stub
        resp.getWriter().append("Served at: ").append(req.getContextPath())
    }

    /**
     * Do post
     *
     * @param req
     * @param resp
     */
    @Throws(ServletException::class, IOException::class)
    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse?) {
        // TODO Auto-generated method stub
        //doGet(req, resp);
        req.session.removeAttribute(ConstantDef.USER_SESSION)
        val userName: String = req.getParameter("user")
        val pwd: String = req.getParameter("pwd")
//        val bll = UserBll()
        val bll = UserDal()
        //
        var model: UserModel? = null
        try {
            model = bll.login(userName, pwd)
            if (model != null) {
                req.session.setAttribute(ConstantDef.USER_SESSION, model)
                //已经获得当前登录用户的前两个美拍
                val pais: MutableList<MeiPaiModel> = ArrayList()
                var pai = MeiPaiModel("My first Mei", 1)
                pai.content = "Created at Luoyang City on 12/6/2021."
                pai.setnCollect(10)
                pai.setnFavorite(
                    0
                )
                pai.coverPic = "lit-cover-1.jpg"
                pai.contentPic = "lit-content-1.jpg"
                val owner = UserModel("zhaoqi", "123")
                owner.setId(3)
                pai.owner = owner
                pais.add(pai)
                //
                pai = MeiPaiModel("My second Mei", 2)
                pai.content = "Created at Luoyang City on 12/6/2021."
                pai.setnCollect(20)
                pai.setnFavorite(5)
                pai.coverPic = "lit-cover-2.jpg"
                pai.contentPic = "lit-content-2.jpg"
                pai.owner = model
                pais.add(pai)
                req.session.setAttribute(ConstantDef.USER_MEIPAIS, pais)
                req.getRequestDispatcher("index.jsp").forward(req, resp)
            } else {
            }
        } catch (ex: Exception) {
            println(ex)
        }
    }


}