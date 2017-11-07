package com.liu233w.library.beans;

/**
 * 表示错误的 bean，传递给 error.jsp 或者其他错误处理页面，用于保存给用户的错误信息
 */
public class ErrorBean {
    private String title;
    private String detail;

    public ErrorBean() {
    }

    public ErrorBean(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
