package com.liu233w.library.controller;

import com.liu233w.library.Main;
import com.liu233w.library.beans.ErrorBean;
import com.liu233w.library.core.RoleNames;
import com.liu233w.library.core.UserHelper;
import com.liu233w.library.model.UsersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sun.security.validator.ValidatorException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 负责注册的页面
 */
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("Name");
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");

        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();

        /* begin: 验证输入合法性 */
        try {
            UserHelper.ensureField("Name", name);
            UserHelper.ensureField("Email", email);
            UserHelper.ensureField("Password", password);

            List res = session.createQuery("from UsersEntity " +
                    "where name = :name or email = :email")
                    .setParameter("name", name)
                    .setParameter("email", email)
                    .list();
            if (res.size() >= 1) {
                throw new ValidatorException("用户名或Email已经存在");
            }
        } catch (ValidatorException e) {

            transaction.rollback();
            session.close();

            request.setAttribute("error", new ErrorBean(e.getMessage(), ""));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/Account/Register.jsp");
            requestDispatcher.forward(request, response);
            return;
        }
        /* end */

        session.save(new UsersEntity(name, email, RoleNames.READER, password));
        transaction.commit();
        session.close();

        UserHelper.login(email, password, request);

        response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/Account/Register.jsp");

        requestDispatcher.forward(request, response);
    }
}
