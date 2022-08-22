package com.hi.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final UserRepository userRepository;


//    @GetMapping("/hi")
//    public User testcon(){
//
////        return new User("test", 777L);
//    }

    //파일 인자로 받고 한 줄 씩 읽어들여서(개행문자 기준) 끝까지 출력하는 프로그램
    @PostMapping("/read")
    @Transactional
    public List<User> readFile(MultipartFile test) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(test.getInputStream(),"UTF-8"));
        String line=null;
        List<User> userList =new ArrayList<>();
        while((line=br.readLine())!=null){
            System.out.println(line);
            String[] s=line.split(",");
            userDto tmp=new userDto(Long.parseLong(s[1]),s[0]);
            System.out.println(tmp.getAge());
            User user=new User(tmp);
            userRepository.save(user);
            userList.add(user);
        }
        br.close();
        System.out.println(userList);
//        System.out.println(userRepository.findAll());
        return userList;
    }
}
