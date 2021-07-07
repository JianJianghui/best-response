package com.github.jianjianghui.response.v1;

/**
 * response
 *
 * @author <a href="mailto:jianjianghui@foxmail.com" >Jianghui Jian</a>
 * @date 2021/7/7 - 15:23
 */
public class Response<T> {
    private static int DEFAULT_SUCCESS_CODE = 0;
    private static int DEFAULT_ERROR_CODE = -1;

    private static String DEFAULT_SUCCESS_MESSAGE = "successful";
    private static String DEFAULT_ERROR_MESSAGE = "fail";

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

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
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


    public static void defaultSuccessCode(int successCode) {
        Response.DEFAULT_SUCCESS_CODE = successCode;
    }

    public static void defaultSuccessMessage(String successMessage) {
        Response.DEFAULT_SUCCESS_MESSAGE = successMessage;
    }

    public static int defaultSuccessCode() {
        return Response.DEFAULT_SUCCESS_CODE;
    }

    public static String defaultSuccessMessage() {
        return Response.DEFAULT_SUCCESS_MESSAGE;
    }

    public static void defaultErrorCode(int errorCode) {
        Response.DEFAULT_ERROR_CODE = errorCode;
    }

    public static void defaultErrorMessage(String errorMessage) {
        Response.DEFAULT_ERROR_MESSAGE = errorMessage;
    }

    public static int defaultErrorCode() {
        return Response.DEFAULT_ERROR_CODE;
    }

    public static String defaultErrorMessage() {
        return Response.DEFAULT_ERROR_MESSAGE;
    }


    private Response(int code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }
}
