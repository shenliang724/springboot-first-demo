package com.oyo.shen.Service;

import com.oyo.shen.Dao.StudentDao;
import com.oyo.shen.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    // 通过id查找学生
    public List<Student> findStudentById(int id){

       return studentDao.findStudentById(id);

    }

    // 查询所有的数据，并以list的形式返回json
    public List<Student> findList(Student student){
        return studentDao.findList(student);
    }


    //根据id删除一整条学生信息
    @Transactional(readOnly = false)
    public  void delete(Student student){
        studentDao.delete(student);
    }

    @Transactional(readOnly = false)
    public void insertList(Student student){
     studentDao.insertList(student);
    }

    @Transactional(readOnly = false)
    public void updateList(Student student){
        studentDao.updateList(student);
    }





}
