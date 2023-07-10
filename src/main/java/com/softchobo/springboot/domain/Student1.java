package com.softchobo.springboot.domain;

import lombok.Value;

@Value  //Lombok private field로 만들어 준다.
public class Student1 {
    String name;
    Integer age;
    Grade grade;

    public enum Grade {
        A, B, C, D, E
    }

}