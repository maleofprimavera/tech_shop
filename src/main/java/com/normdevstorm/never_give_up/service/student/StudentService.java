package com.normdevstorm.never_give_up.service.student;

import com.normdevstorm.never_give_up.model.student.Student;
import com.normdevstorm.never_give_up.repository.student.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class StudentService{


    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public final List<Student> printOutStuList() {
        return List.of(new Student("1", "Nam Nguyen Xuan", Date.valueOf("2003-12-30"), 20), new Student("2", "Nam Nguyen Xuan", Date.valueOf("2003-12-30"), 20), new Student("3", "Nam Nguyen Xuan", Date.valueOf("2003-12-30"), 20))
                ;
    }
    public final void saveStudent(List<Student> students){
         studentRepository.saveAll(students);
    }

    public List<Student> findStudentById(String id)
    {
        return studentRepository.findAllById(List.of(id));
    }

    @Transactional
    public void deleteById(String id) {
        studentRepository.deleteStudentById(id);
    }

    @Transactional
    public void updateStudent(String id, Student student) {
        studentRepository.updateStudentById(id,student.getId(), student.getName(),student.getAge(), student.getDob());
    }
}
