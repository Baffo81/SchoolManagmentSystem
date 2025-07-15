package dev.archety.sms.repositories;

import dev.archety.sms.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
// This interface extends JpaRepository to provide CRUD operations for the Student entity.
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Method to find students by last name
    List<Student> findByfirstName(String firtsName);

    // Method to find students by substring in last name
    List<Student> findBylastNameContaining(String substring);

    // Method to find students by domain in email
    List<Student> findByEmail(String domain);

    // Method to find students by first and last name
    @Query("SELECT s FROM Student s WHERE s.lastName LIKE %:lastName%")
    List<Student> findALLOrderByLastNameAsc();

    @Query("Select Count(c) From Student s Join s.courses c Where s.id = :studentId")
    Long countCoursesByStudentID(Integer studentId);


}
