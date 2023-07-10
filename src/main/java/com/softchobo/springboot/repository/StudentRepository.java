package com.softchobo.springboot.repository;

import com.softchobo.springboot.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Map;

@RequiredArgsConstructor
@Component
public class StudentRepository {

    private final Map<String, Student> storage;

    @Cacheable("student")
    public Student getStudent(String name) {
        System.out.println("[repo] 나의 통행료는 무착 비싸다!");
        return storage.get(name);
    }

    public Student enroll(String name, Integer age, Student.Grade grade) {
        return storage.put(name, Student.of(name, age, grade));
    }
}
