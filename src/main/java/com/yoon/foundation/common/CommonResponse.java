package com.yoon.foundation.common;

public record CommonResponse<T>(
        boolean success,
        T response,
        ErrorResponse error
) {
    public static <T> CommonResponse<T> success(T response) {
        return new CommonResponse<>(true, response, null);
    }
}
