package com.liu233w.library.controller;

import com.liu233w.library.core.UserHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 负责登陆的页面
 */
public class LoginServlet extends HttpServlet {
    private int REMEMBER_ME_COOKIE_MAX_AGE = 60 * 60 * 24 * 30;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");
        String rememberMe = request.getParameter("RememberMe");

        System.out.println("用户 " + email + " 请求登陆");

        boolean success = UserHelper.login(email, password, request);
        if (success) {
            if (rememberMe != null && rememberMe.equals("true")) {

                Cookie emailCookie = new Cookie("email", email);
                emailCookie.setPath("/");
                emailCookie.setMaxAge(REMEMBER_ME_COOKIE_MAX_AGE);
                Cookie passwordCookie = new Cookie("password", password);
                passwordCookie.setPath("/");
                passwordCookie.setMaxAge(REMEMBER_ME_COOKIE_MAX_AGE);

                response.addCookie(emailCookie);
                response.addCookie(passwordCookie);
            }
            response.sendRedirect("/");
        } else {
            response.sendRedirect("/Account/Login?failed=1");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/Account/Login.jsp");

        requestDispatcher.forward(request, response);
    }
}
