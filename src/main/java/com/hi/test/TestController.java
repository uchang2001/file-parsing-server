package com.hi.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {


    @GetMapping("/hi")
    public userDto testcon(){

        return new userDto("test", 777L);
    }

    //파일 인자로 받고 한 줄 씩 읽어들여서(개행문자 기준) 끝까지 출력하는 프로그램
    @PostMapping("/read")
    public List<userDto> readFile(MultipartFile test) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(test.getInputStream(),"UTF-8"));
        String line=null;
        List<userDto> userDtoList =new ArrayList<>();
        while((line=br.readLine())!=null){
            System.out.println(line);
            String[] s=line.split(",");
            userDto tmp=new userDto(s[0],Long.parseLong(s[1]));
            userDtoList.add(tmp);
        }
        br.close();
        System.out.println(userDtoList);
        return userDtoList;
    }
}
