package com.liu233w.library.model;

import com.liu233w.library.Main;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.awt.print.Book;
import java.util.List;

/**
 * 封装了对 Book 数据表的操作
 */
public class BookRepository {
    /**
     * 获取所有书籍
     *
     * @return 书籍列表
     */
    public static List<BooksEntity> getAllBooks() {
        Session session = Main.getSession();
        Query query = session.createQuery("from BooksEntity");
        List books = query.getResultList();
        session.close();
        return books;
    }

    /**
     * 根据书籍id来删除书籍，如果id不存在，不会产生什么异常
     *
     * @param id 书籍id
     */
    public static void deleteBookById(int id) {
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();

        session.createQuery("delete BooksEntity where id = :id")
                .setParameter("id", id)
                .executeUpdate();
        transaction.commit();

        session.close();
    }

    /**
     * 根据 id 获取书籍
     *
     * @param id 书籍的数据库id
     * @return 书籍，如果不存在，返回 null
     */
    public static BooksEntity getBookOrNullById(int id) {
        Session session = Main.getSession();
        List books = session
                .createQuery("from BooksEntity where id = :id")
                .setParameter("id", id)
                .getResultList();

        session.close();

        if (books.size() == 0) {
            return null;
        } else {
            return (BooksEntity) books.get(0);
        }
    }

    /**
     * 添加书籍
     *
     * @param book 书籍实体
     */
    public static void addBook(BooksEntity book) {
        Session session = Main.getSession();

        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();

        session.close();
    }

    /**
     * 根据 id 来更新书籍。id从 book 中获取，数据库中当前行的所有值（除了id）
     * 都会更新成 参数book中的值。
     *
     * @param book 书籍
     * @return 更新成功，返回 true；如果id在数据库中不存在，返回false
     */
    public static boolean updateBookById(BooksEntity book) {
        Session session = Main.getSession();

        Transaction transaction = session.beginTransaction();
        List books = session.createQuery("from BooksEntity where id = :id")
                .setParameter("id", book.getId())
                .getResultList();
        if (books.size() == 0) {
            session.close();
            return false;
        }

        BooksEntity bookEntity = (BooksEntity) books.get(0);
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setLocation(book.getLocation());
        bookEntity.setPublisher(book.getPublisher());
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setDescription(book.getDescription());

        session.update(bookEntity);

        transaction.commit();
        session.close();

        return true;
    }
}
