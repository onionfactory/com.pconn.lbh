package com.pconn.book.springboot.web;
import com.pconn.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, //외부에 api로 넘긴 파라미터를 가져오는 어노테이션
                                     @RequestParam("amount") int amount){

        return new HelloResponseDto(name, amount);
    }
}

//HTTP Get요청을 받는 API
//컨트롤러를 JSON으로 반환하는 컨트롤러