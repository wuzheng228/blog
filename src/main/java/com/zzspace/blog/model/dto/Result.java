package com.zzspace.blog.model.dto;

import java.io.Serializable;

/**
 * Created by 76973 on 2021/7/3 10:51
 */
public class Result<T> implements Serializable {

    private final static String DEFAULT_SUCCESS_MSG = "success";
    private final static String DEFAULT_FAILED_MSG = "failed";

    private boolean success;
    private String msg;
    private String code;
    private T data;

    public Result() {
    }

    public Result(boolean success, String msg, String code, T data) {
        this.success = success;
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static <T> Result<T> success(T data, String message) {
        return new Result<T>(true, message, null, data);
    }

    public static <T> Result<T> failed(T data, String message) {
        return new Result<T>(false, message, null, data);
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> failed() {
        return failed(null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(true, DEFAULT_SUCCESS_MSG, null, data);
    }

    public static <T> Result<T> failed(T data) {
        return new Result<T>(false, DEFAULT_FAILED_MSG, null, data);
    }

    public boolean getSuccess() {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
