package com.pconn.book.springboot.web.dto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 모든 필드의 get메소드를 자동생성
@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자를 생성 final이 없다면 생성 x
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
