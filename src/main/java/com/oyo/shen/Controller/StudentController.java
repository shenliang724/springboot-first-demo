package com.oyo.shen.Controller;

import com.oyo.shen.Entity.Student;
import com.oyo.shen.Service.StudentService;
import com.oyo.shen.common.BaseController;
import com.oyo.shen.common.VResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/stu")
public class StudentController extends BaseController {


        //controller层中自动注入service层，在controller中调用service层中的代码
        @Autowired
        private StudentService studentService;


        // 通过Id查询信息
        @GetMapping("/findStudentById")
        public List<Student>  findStudentById(int id){
            return studentService.findStudentById(id);
        }


        //以一个List包含起来，返回的Json包含早result中，显示为列表
        @GetMapping(value = "/findList")
        public VResponse<List<Student>> getList(Student student){
            List<Student> list = studentService.findList(student);
            return VResponse.success(list);
        }


        // 根据ID来删除一个student
        @PostMapping(value = "/delete")
        public VResponse<Object> deleteList(@RequestBody Student student){
            System.out.println(student);
            studentService.delete(student);
            return VResponse.success("删除成功");
        }


        @RequestMapping(value = "/formList",method= RequestMethod.POST)
        public VResponse<Object> formList(Student student){
            return VResponse.success((Object)student);
        }

        @PostMapping(value = "/insertList")
        public VResponse<Object> insertList( @RequestBody Student student, Model model){
            System.out.println("执行了吗");
           if (!beanValidator(model,student)){
            return formList(student);
           }
        studentService.insertList(student);
        return VResponse.success("增加成功");
        }
    /**
     * 通过id更新一条数据
     * @param student
     * @param model
     * @return
     * http://localhost:8088/stu/updateList
     */
        @PostMapping(value = "/updateList")
        public VResponse<Object> updateList(@RequestBody Student student,Model model){
            if (!beanValidator(model,student)){
            return formList(student);
            }
            studentService.updateList(student);
            return VResponse.success("更新成功");
        }

    @PostMapping(value = "/updateList1")
    public VResponse<Object> updateList1(@RequestBody Student student,Model model){
        if (!beanValidator(model,student)){
            return formList(student);
        }
        studentService.updateList(student);
        return VResponse.success("更新成功");
    }
}
