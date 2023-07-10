package com.softchobo.springboot.domain;

public record Person(String name, Integer age, Grade grade) {

    public enum Grade {
        A, B, C, D, E
    }

}
