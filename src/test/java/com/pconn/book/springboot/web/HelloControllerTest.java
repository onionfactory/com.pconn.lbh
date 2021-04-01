package com.pconn.book.springboot.web;

import com.pconn.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) //1. 테스트를 진행할 때 JUnit이 아닌 스프링부트 테스트를 실행시킴
@WebMvcTest//(controllers = HelloController.class) //2. 여러 스프링 테스트 annotation중 web에 집중 할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈을 주입받음.
    private MockMvc mvc; // 웹 api를 테스트 할 때 사용됨. 스프링 mvc테스트의 시작점임 이를 이용한 api 테스트가 쌉가능.

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello주소로 get요청을 함. 체이닝이 지원됨.
                .andExpect(status().isOk()) //mvc.perform의 결과를 검증함. status를 검증.
                .andExpect(content().string(hello)); // 응답 본문의 내용을 검증함. 반환값이 hello가 맞는지 검증함.
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                    .param("name", name)
                    .param("amount", String.valueOf(amount)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name", is(name)))
                    .andExpect(jsonPath("$.amount", is(amount)));
    }
    // param = api 테스를 할 때 사용될 요청 파라미터를 설정함.
    // 1. 단 값은 string만 허용됨.
    // 2. 그래서 숫자 날짜 등의 데이터도 등록을 할 때는 문자열로 변경해야만 함.
    // jsonPath = JSON 응답값을 필드별로 검증할 수 있는 메소드임.
    // 1. $를 기준으로 필드명을 명시합니다.
    // 2. 여기서는 name과 amount로 검증하니 $.name $.amount로 검증합니다.


}
