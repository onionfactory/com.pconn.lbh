package com.pconn.book.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

// SpringApplication으로 스프링 부트의 자동 설정, 스프링 bean 읽기와 생성을 모두 자동으로 설정됨.
// 1. 위 어노테이션이 있는 위치부터 설정을 읽기 때문에 항상 이 클래스는 프로젝트의 최상단에 위치해야 함.

// SpringApplication.run으로 인해 내장 WAS를 실행함.
// 이때문에 was를 굳이 설치하지 않아도 됨.