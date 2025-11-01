package com.example.seungchang.global.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // 404 Not Found
    VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    NOT_FOUND_RESTAURANT_EXCEPTION(HttpStatus.NOT_FOUND, "찾을 수 없는 식당"),

    // 409 Conflict
    ALREADY_EXIST_RESTAURANT_EXCEPTION(HttpStatus.CONFLICT, "이미 존재하는 식당입니다."),

    //500 Server Unavailable
    INTERNAL_SERVER_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 서버 에러가 발생했습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
