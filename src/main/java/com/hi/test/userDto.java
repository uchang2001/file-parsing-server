package com.hi.test;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class userDto {
    private String name;
    private Long age;

    public userDto(String name, Long age){
        this.name=name;
        this.age=age;
    }
}
