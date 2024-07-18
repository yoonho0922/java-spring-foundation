package com.yoon.foundation.common;

public record ErrorResponse(
        String message,
        String errorCode,
        int statusCode
) {
}
