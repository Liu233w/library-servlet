package com.liu233w.library.tags;

import com.liu233w.library.beans.UserBean;
import com.liu233w.library.core.MenuItem;
import com.liu233w.library.core.MenuProvider;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * 用来展示左侧的菜单栏，菜单栏在 {@link MenuProvider} 中编辑。
 * 当用户拥有对应菜单项的权限时，会展示此菜单项
 */
public class MenuTag extends SimpleTagSupport {

    @Override
    public void doTag() throws IOException {
        UserBean user = (UserBean) getJspContext().getAttribute("user", PageContext.SESSION_SCOPE);
        String userRole = user == null ? null : user.getRole();

        JspWriter writer = getJspContext().getOut();

        writer.print("<div class=\"menu\">" +
                "  <ul class=\"list\">");

        for (MenuItem item :
                MenuProvider.getMenu()) {
            String role = item.getRole();
            if (role == null || role.equals("") || role.equals(userRole)) {
                // 用户有访问页面的权限（或者页面可以让任何人访问）
                writer.print("<li>" +
                        "    <a href=\"" + item.getUrl() + "\">" +
                        "      <i class=\"material-icons\">" + item.getIcon() + "</i>" +
                        "      <span>" + item.getName() + "</span>" +
                        "    </a>");
            }
        }

        writer.print("</ul>" +
                "</div>");
    }
}
