package com.carrental.demo.vo;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private T data;
    private boolean success;
    private String msg;
    private int code;

    public Result(T data, boolean success, String msg, int code) {
        this.data = data;
        this.success = success;
        this.msg = msg;
        this.code = code;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(data, true, "", 0);
    }
    public static <T> Result<T> success() {
        return new Result<>(null, true, "", 0);
    }

    public static Result fail(int code, String msg) {
        return new Result(null, false, msg, code);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
