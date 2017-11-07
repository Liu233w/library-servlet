package com.liu233w.library.controller;

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
 * 添加书籍的页面
 */
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BooksEntity book = BookHelper.mapBook(request);
        BookRepository.addBook(book);

        response.sendRedirect("/BookList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("title", "Add a new book");
        request.setAttribute("book", new BooksEntity());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/BookEdit.jsp");
        requestDispatcher.forward(request, response);
    }
}
