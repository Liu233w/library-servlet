package com.liu233w.library.core;

import com.liu233w.library.Main;
import com.liu233w.library.model.BooksEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.http.HttpServletRequest;

/**
 * 跟书籍相关的辅助函数，例如映射 beans 之类的
 */
public class BookHelper {
    /**
     * 从 requests 中获取参数，映射到 {@link BooksEntity} bean 中
     * @param request servlet 的 request
     * @return 映射完成的 bean
     */
    public static BooksEntity mapBook(HttpServletRequest request) {
        BooksEntity book = new BooksEntity();

        String id = request.getParameter("id");
        if (id != null && !id.equals("")) {
            book.setId(Integer.parseInt(id));
        }

        book.setTitle(request.getParameter("title"));
        book.setIsbn(request.getParameter("isbn"));
        book.setAuthor(request.getParameter("author"));
        book.setDescription(request.getParameter("description"));
        book.setPublisher(request.getParameter("publish"));
        book.setLocation(request.getParameter("location"));

        return book;
    }
}
