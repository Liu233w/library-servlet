package com.liu233w.library.core;

/**
 * 表示一个菜单项，用在 {@link MenuProvider} 中
 */
public class MenuItem {
    private String url;
    private String icon;
    private String name;
    private String role;

    /**
     * 创建一个菜单项
     *
     * @param name 菜单的标题
     * @param url  菜单项指向的 url
     * @param icon 菜单的图标
     * @param role 显示菜单需要的用户角色（如果为 null，表示任何用户都可以看到此菜单项）
     */
    public MenuItem(String name, String url, String icon, String role) {
        this.url = url;
        this.icon = icon;
        this.name = name;
        this.role = role;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
