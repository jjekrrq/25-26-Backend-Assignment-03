package com.example.seungchang.global.responseTemplate;

import com.example.seungchang.global.code.ErrorCode;
import com.example.seungchang.global.code.SuccessCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class ApiResponseTemplate<T> {
    private final int status;       // HTTP 상태 코드
    private final boolean success;  // 성공 여부
    private final String message;   // 메시지
    private T data;                 // 실제 응답 데이터

    // 성공 응답
    public static <T> ResponseEntity<ApiResponseTemplate<T>> success(SuccessCode successCode, T data) {
        return ResponseEntity
                .status(successCode.getHttpStatus())
                .body(ApiResponseTemplate.<T>builder()
                        .status(successCode.getHttpStatus().value())
                        .success(true)
                        .message(successCode.getMessage())
                        .data(data)
                        .build());
    }

    // 실패 응답
    public static <T> ResponseEntity<ApiResponseTemplate<T>> error(ErrorCode errorCode) {
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(ApiResponseTemplate.<T>builder()
                        .status(errorCode.getHttpStatus().value())
                        .success(false)
                        .message(errorCode.getMessage())
                        .build());
    }
}
