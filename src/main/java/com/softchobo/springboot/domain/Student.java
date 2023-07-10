package com.softchobo.springboot.domain;

import lombok.Value;

import java.io.Serializable;

//record : 생성자 + equals + hashCode + toString 자동 생성
//         getter 는 get 문자 없이 field 자체 이름으로 사용
//public record Student(String name, Integer age, Grade grade) implements Serializable {
public record Student(String name, Integer age, Grade grade) {
    public enum Grade {
        A, B, C, D, E, F
    }

    public static Student of(String name, Integer age, Grade grade) {
        return new Student(name, age, grade);
    }

}