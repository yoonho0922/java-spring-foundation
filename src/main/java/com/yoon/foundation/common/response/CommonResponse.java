package com.yoon.foundation.common.response;

public record CommonResponse<T>(
        boolean success,
        T response,
        ErrorResponse error
) {
    public static <T> CommonResponse<T> success(T response) {
        return new CommonResponse<>(true, response, null);
    }
}
