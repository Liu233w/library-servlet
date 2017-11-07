package com.liu233w.library.filter;

import com.liu233w.library.core.UserHelper;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 处理自动登陆。如果用户在登陆时点击了 “Remember Me”，系统会把用户名和密码存进Cookie里面。
 * 这个 Filter 会在探测到 Session 中没有用户信息的时候使用 Cookie 自动登陆。
 * <p>
 * 注：正常情况下 Cookie 里面应该保存 JWT 的，这里图省事保存用户名和密码了
 */
public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        // System.out.println("AutoLogin Filter");

        HttpServletRequest request = (HttpServletRequest) req;
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession(true);

        if (session.getAttribute("user") == null) {
            String email = "";
            String password = "";
            for (Cookie item :
                    cookies) {
                String name = item.getName();
                if (name.equals("email")) {
                    email = item.getValue();
                } else if (name.equals("password")) {
                    password = item.getValue();
                }
            }

            if (!email.equals("") && !password.equals("")) {
                System.out.println("开始自动登陆，用户： " + email);
                UserHelper.login(email, password, request);
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
