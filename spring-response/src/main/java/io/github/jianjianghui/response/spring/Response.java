package io.github.jianjianghui.response.spring;

import org.springframework.http.HttpStatus;

/**
 * @author <a href="https://www.github.com/jianjianghui">Jianghui Jian<a/>
 * @date 2022/8/23 - 17:16
 */
public class Response<T> {
    public static int DEFAULT_SUCCESS_CODE = HttpStatus.OK.value();
    public static int DEFAULT_ERROR_CODE = HttpStatus.INTERNAL_SERVER_ERROR.value();

    public static String DEFAULT_SUCCESS_MESSAGE = "success";
    public static String DEFAULT_ERROR_MESSAGE = "error";

    /**
     * DEFAULT_ERROR_CODE code
     */
    int code;

    /**
     * message
     */
    String message;

    /**
     * data
     */
    T data;

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Response() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private static <T> Response<T> create(int code, String msg, T data) {
        return new Response<>(code, msg, data);
    }


    public static <T> Response<T> success(String msg, T data) {
        return create(DEFAULT_SUCCESS_CODE, msg, data);
    }

    public static <T> Response<T> success(String msg) {
        return create(DEFAULT_SUCCESS_CODE, msg, null);
    }

    public static <T> Response<T> success(T data) {
        return create(DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, data);
    }

    public static <T> Response<T> success() {
        return create(DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, null);
    }


    public static <T> Response<T> error(int code, String msg, T data) {
        return create(code, msg, data);
    }

    public static <T> Response<T> error(int code, String msg) {
        return create(code, msg, null);
    }

    public static <T> Response<T> error(String msg, T data) {
        return create(DEFAULT_ERROR_CODE, msg, data);
    }

    public static <T> Response<T> error(String msg) {
        return create(DEFAULT_ERROR_CODE, msg, null);
    }

    public static <T> Response<T> error(T data) {
        return create(DEFAULT_ERROR_CODE, DEFAULT_ERROR_MESSAGE, data);
    }

    public static <T> Response<T> error() {
        return create(DEFAULT_ERROR_CODE, DEFAULT_ERROR_MESSAGE, null);
    }



    public static void setDefaultSuccessCode(int successCode) {
        Response.DEFAULT_SUCCESS_CODE = successCode;
    }

    public static void setDefaultSuccessMessage(String successMessage) {
        Response.DEFAULT_SUCCESS_MESSAGE = successMessage;
    }

    public static void setDefaultErrorCode(int errorCode) {
        Response.DEFAULT_ERROR_CODE = errorCode;
    }

    public static void setDefaultErrorMessage(String errorMessage) {
        Response.DEFAULT_ERROR_MESSAGE = errorMessage;
    }
}
