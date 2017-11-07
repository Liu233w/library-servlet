package com.liu233w.library.tags;

import com.liu233w.library.beans.UserBean;
import com.liu233w.library.core.RoleNames;
import com.liu233w.library.model.BooksEntity;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.MessageFormat;

/**
 * 表示列表中的一条书籍信息，根据用户的角色判断是否展示编辑按钮
 */
public class BookItemTag extends SimpleTagSupport {
    private BooksEntity book;

    @Override
    public void doTag() throws IOException {
        JspWriter writer = getJspContext().getOut();

        UserBean user = (UserBean) getJspContext().getAttribute("user", PageContext.SESSION_SCOPE);
        String userRole = user == null ? null : user.getRole();

        String editBookButton = "";
        if (userRole != null && userRole.equals(RoleNames.MANAGER)) {
            editBookButton = "<a class=\"btn btn-primary\" " +
                    "href=\"/BookManage/Edit?id=" + book.getId() + "\">Edit</a>";
        }

        writer.print(MessageFormat.format("<tr>" +
                        "                  <td>{0}</td>" +
                        "                  <td>{1}</td>" +
                        "                  <td>{2}</td>" +
                        "                  <td>{3}</td>" +
                        "                  <td>{4}</td>" +
                        "                  <td>{5}</td>" +
                        "                  <td>{6}</td>" +
                        "                </tr>",
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getIsbn(),
                book.getDescription(),
                book.getLocation(),
                editBookButton
        ));
    }

    public BooksEntity getBook() {
        return book;
    }

    public void setBook(BooksEntity book) {
        this.book = book;
    }
}
