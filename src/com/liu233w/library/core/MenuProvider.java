package com.liu233w.library.core;

/**
 * 在此处声明菜单项的内容、权限，用于展示菜单
 */
public class MenuProvider {
    public static MenuItem[] getMenu() {
        return new MenuItem[]{
                new MenuItem("Home", "/", "home", null),
                new MenuItem("Book List", "/BookList", "view_list", null),
                new MenuItem("Add Book", "/BookManage/Add", "description", RoleNames.MANAGER),
                new MenuItem("Borrow Book", "/BookManage/BorrowBook", "pan_tool", RoleNames.MANAGER)
        };
    }
}
