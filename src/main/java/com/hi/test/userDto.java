package com.hi.test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class userDto {
    private Long age;
    private String name;
    public userDto(Long age,String name){
        this.age=age;

        this.name=name;
    }

}
