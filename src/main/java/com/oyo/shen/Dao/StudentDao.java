package com.oyo.shen.Dao;

import com.oyo.shen.Entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 学生dao层
 */

@Mapper
public interface StudentDao {

    List<Student> findStudentById(int id);

    int delete(Student id);

    List<Student> findList(Student student);

    void insertList(Student student);

    void updateList(Student student);

}