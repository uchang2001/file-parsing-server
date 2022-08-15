package com.hi.test;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class testdto {
    private String s;
    private Long l;

    public testdto(String s,Long l){
        this.s=s;
        this.l=l;
    }
}
