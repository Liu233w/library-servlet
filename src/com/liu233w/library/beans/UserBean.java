package com.liu233w.library.beans;

/**
 * 用来表示 {@link com.liu233w.library.model.UsersEntity} 的 bean（作为 DTO 使用）
 * <p>
 * 由于用户的 Entity 中包含了一些不便传递的重要信息（例如密码），这些不便于保存进 Session 中
 * 或直接传递给 jsp 页面，所以最好用 bean 做一下映射。
 */
public class UserBean {
    private int id;
    private String name;
    private String email;
    private String role;

    public UserBean() {
    }

    public UserBean(int id, String name, String email, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
