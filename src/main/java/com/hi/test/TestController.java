package com.hi.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
public class TestController {


    @GetMapping("/hi")
    public testdto testcon(){

        return new testdto("test", 777L);
    }

    //파일 인자로 받고 한 줄 씩 읽어들여서(개행문자 기준) 끝까지 출력하는 프로그램
    @PostMapping("/hi")
    public String ttt(MultipartFile t) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(t.getInputStream(),"UTF-8"));
        String line=null;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
        return "";
    }

    //TO-DO 쉼표 (,) 기준으로 나눠서 파싱하기
}