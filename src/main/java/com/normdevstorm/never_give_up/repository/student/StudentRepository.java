package com.normdevstorm.never_give_up.repository.student;

import com.normdevstorm.never_give_up.model.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    @Modifying
    @Query(value = "DELETE FROM student WHERE student.id = ?1", nativeQuery = true)
    void deleteStudentById(String id);

    @Modifying
    @Query(value = "UPDATE student s SET id = ?2, name = ?3, age = ?4, dob = ?5 WHERE s.id = ?1", nativeQuery = true)
    void updateStudentById(String queryId, String newId, String name, int age, java.sql.Date dob);
}
