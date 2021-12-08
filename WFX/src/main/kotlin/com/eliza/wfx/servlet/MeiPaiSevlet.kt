package com.eliza.wfx.servlet

import jakarta.servlet.ServletException
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.io.IOException


@WebServlet("/meipai")
open class MeiPaiServlet {

    companion object {
        private const val serialVersionUID = 1L
    }

    @Throws(ServletException::class, IOException::class)
    protected fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        // TODO Auto-generated method stub
        //id
        //访问数据库得到meipai
        //request.attribute
        //dispatcher.forward
        response.writer.append("Served at: ").append(request.contextPath)
    }

    /**
     * Do post
     *
     * @param request
     * @param response
     */
    @Throws(ServletException::class, IOException::class)
    protected fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        // TODO Auto-generated method stub
        doGet(request, response)
    }


}
