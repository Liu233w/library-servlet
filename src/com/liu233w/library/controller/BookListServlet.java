package com.liu233w.library.controller;

import com.liu233w.library.model.BookRepository;
import com.liu233w.library.model.BooksEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 展示书籍列表的页面
 */
public class BookListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BooksEntity> books = BookRepository.getAllBooks();
        request.setAttribute("books", books);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/BookList.jsp");
        requestDispatcher.forward(request, response);
    }
}
