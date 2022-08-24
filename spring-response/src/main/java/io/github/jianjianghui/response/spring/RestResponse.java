package io.github.jianjianghui.response.spring;

import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

import static io.github.jianjianghui.response.spring.Response.*;

/**
 *
 * @author @author <a href="https://www.github.com/jianjianghui">Jianghui Jian<a/>
 * @date 2022/8/23 - 17:05
 */
public class RestResponse <T> extends ResponseEntity<Response<T>> {

    public RestResponse(HttpStatus status) {
        super(status);
    }

    public RestResponse(Response<T> body, HttpStatus status) {
        super(body, status);
    }

    public RestResponse(MultiValueMap<String, String> headers, HttpStatus status) {
        super(headers, status);
    }

    public RestResponse(Response<T> body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }

    public RestResponse(Response<T> body, MultiValueMap<String, String> headers, int rawStatus) {
        super(body, headers, rawStatus);
    }




    public static <T> RestResponse<T> success(String msg, T data) {
        return new RestResponse<>(Response.success(msg, data), new HttpHeaders(), DEFAULT_SUCCESS_CODE);
    }

    public static <T> RestResponse<T> success(String msg) {
        return new RestResponse<>(Response.success(msg, null), new HttpHeaders(), DEFAULT_SUCCESS_CODE);
    }

    public static <T> RestResponse<T> success(T data) {
        return new RestResponse<>(Response.success(DEFAULT_SUCCESS_MESSAGE, data), new HttpHeaders(), DEFAULT_SUCCESS_CODE);
    }

    public static <T> RestResponse<T> success() {
        return new RestResponse<>(Response.success(DEFAULT_SUCCESS_MESSAGE, null), new HttpHeaders(), DEFAULT_SUCCESS_CODE);
    }


    public static <T> RestResponse<T> error(int code, String msg, T data) {
        return new RestResponse<>(Response.error(code,msg, data), new HttpHeaders(), code);
    }

    public static <T> RestResponse<T> error(int code, String msg) {
        return new RestResponse<>(Response.error(code,msg, null), new HttpHeaders(), code);
    }

    public static <T> RestResponse<T> error(String msg, T data) {
        return new RestResponse<>(Response.error(DEFAULT_ERROR_CODE,msg, data), new HttpHeaders(), DEFAULT_ERROR_CODE);
    }

    public static <T> RestResponse<T> error(String msg) {
        return new RestResponse<>(Response.error(DEFAULT_ERROR_CODE,msg, null), new HttpHeaders(), DEFAULT_ERROR_CODE);
    }

    public static <T> RestResponse<T> error(T data) {
        return new RestResponse<>(Response.error(DEFAULT_ERROR_CODE,DEFAULT_ERROR_MESSAGE, data), new HttpHeaders(), DEFAULT_ERROR_CODE);
    }

    public static <T> RestResponse<T> error() {
        return new RestResponse<>(Response.error(DEFAULT_ERROR_CODE,DEFAULT_ERROR_MESSAGE, null), new HttpHeaders(), DEFAULT_ERROR_CODE);
    }



}
