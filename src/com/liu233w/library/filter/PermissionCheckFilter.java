package com.liu233w.library.filter;

import com.liu233w.library.beans.ErrorBean;
import com.liu233w.library.beans.UserBean;
import com.liu233w.library.core.RoleNames;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用于检测权限，如果没有此权限的用户访问了页面，会返回错误页面
 */
public class PermissionCheckFilter implements Filter {
    private String roleName;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) req).getSession(true);
        UserBean user = (UserBean) session.getAttribute("user");

        if (user != null && user.getRole() != null && user.getRole().equals(roleName)) {

            chain.doFilter(req, resp);
        } else {
            ErrorBean bean = new ErrorBean("Permission Denied",
                    "You don't have permission to visit this page");
            req.setAttribute("error", bean);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        roleName = config.getInitParameter("RoleName");
    }

}
