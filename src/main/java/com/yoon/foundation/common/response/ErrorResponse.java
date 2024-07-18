package com.yoon.foundation.common.response;

public record ErrorResponse(
        String message,
        String errorCode,
        int statusCode
) {
}
