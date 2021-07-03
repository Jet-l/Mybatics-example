package com.dbly.dao;

import com.dbly.entity.Student;

import java.util.List;

public interface IStudentDAO {

    void insertStudent(Student student);

    List<Student> findAllStudent();

    void deleteStudent(int id);

    void updateStudent(Student student);
}
