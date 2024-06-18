package com.normdevstorm.never_give_up.controller.student;

import com.normdevstorm.never_give_up.model.student.Student;
import com.normdevstorm.never_give_up.service.student.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/list")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> printOutStuList() {
        return studentService.printOutStuList();
    }

    @PostMapping("/add")
    public void saveStudent(@RequestBody List<Student> students){
         studentService.saveStudent(students);
    }

    @GetMapping("/filter-by-id/{id}")
    public List<Student> findById(@PathVariable("id") String id)
    {
        return studentService.findStudentById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public void deleteById(@PathVariable("id") String id){
        studentService.deleteById(id);
    }

    @PatchMapping("/update-student")
    public void updateStudent(@RequestParam String id,
    @RequestBody Student student){
        studentService.updateStudent(id, student);
    }


}
