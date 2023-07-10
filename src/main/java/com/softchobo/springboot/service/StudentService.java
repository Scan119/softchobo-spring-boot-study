package com.softchobo.springboot.service;

import com.softchobo.springboot.domain.Student;
import com.softchobo.springboot.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void printStudent(String name) {
        Student student = studentRepository.getStudent(name);
        System.out.println("찾는 학생: " + student);
    }

    @PostConstruct
    public void init() {
        studentRepository.enroll("jack", 15, Student.Grade.B);
        studentRepository.enroll("cassie", 18, Student.Grade.A);
        studentRepository.enroll("fred", 14, Student.Grade.C);
    }
}
