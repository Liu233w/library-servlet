package com.liu233w.library.core;

import com.liu233w.library.Main;
import com.liu233w.library.beans.UserBean;
import com.liu233w.library.model.UsersEntity;
import org.hibernate.Session;
import sun.security.validator.ValidatorException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 包含用户相关的辅助函数
 */
public class UserHelper {
    /**
     * 处理登陆操作（由于这些代码会在多处用到，故将其抽取出来
     *
     * @param email    用户邮箱
     * @param password 用户密码
     * @param request  请求对象
     * @return 登陆成功返回 true，失败（用户不存在、密码错误）返回 false
     */
    public static boolean login(String email, String password, HttpServletRequest request) {
        Session ctx = Main.getSession();

        List<UsersEntity> users = ctx
                .createQuery("from UsersEntity where email = :email")
                .setParameter("email", email)
                .list();

        if (users.size() == 0) {
            return false; // 用户不存在
        }

        UsersEntity user = users.get(0);
        if (!user.getPassword().equals(password)) {
            return false; // 密码错误
        }

        UserBean userBean = new UserBean(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );

        HttpSession session = request.getSession(true);
        session.setAttribute("user", userBean);

        return true;
    }


    /**
     * 确保 value 不为 null 或 空字符串，如果是这样，抛出异常。例如 “ name 字段不能为空”。
     * <p>
     * 由于这个网站很简单，就不使用 validator 了，只用这个函数探测一次就好。
     *
     * @param name  字段名
     * @param value 要检测的值。
     * @throws ValidatorException 检查失败时抛出的异常
     */
    public static void ensureField(String name, String value) throws ValidatorException {
        if (value == null || value.equals("")) {
            throw new ValidatorException("字段 " + name + " 不能为空");
        }
    }
}
