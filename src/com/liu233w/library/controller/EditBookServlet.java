package com.liu233w.library.controller;

import com.liu233w.library.beans.ErrorBean;
import com.liu233w.library.core.BookHelper;
import com.liu233w.library.model.BookRepository;
import com.liu233w.library.model.BooksEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于编辑书籍的页面。 get 操作会生成一个页面，包含书籍的信息。post操作会保存对书籍的修改
 */
public class EditBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BooksEntity book = BookHelper.mapBook(request);

        boolean success = BookRepository.updateBookById(book);
        if (success) {
            response.sendRedirect("/BookList");
        } else {
            request.setAttribute("error", new ErrorBean(
                    "Update Failed",
                    "Can't update book, maybe the id doesn't exist"
            ));

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/error.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        BooksEntity book = BookRepository.getBookOrNullById(id);

        if (book == null) {

            ErrorBean errorBean = new ErrorBean("Book Not Exist", "This book is not exist");
            request.setAttribute("error", errorBean);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/error.jsp");
            requestDispatcher.forward(request, response);

            return;
        }

        request.setAttribute("title", "Edit book: " + book.getTitle());
        request.setAttribute("book", book);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/BookEdit.jsp");
        requestDispatcher.forward(request, response);
    }
}
