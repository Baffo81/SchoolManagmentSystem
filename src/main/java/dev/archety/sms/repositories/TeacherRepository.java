package dev.archety.sms.repositories;

import dev.archety.sms.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    // Method to find teachers by their subject of teaching
    List<Teacher> findByTeachingSubject(String subject);


    // Method to find teachers teaching at least one course
    @Query("Select Distinct t From Teacher t Join Course c ON t.id = c.teacher.id")
    List<Teacher> findTeachersWithLeastOneCourse();

    // Method to find teachers who are not teaching any courses
    @Query("Select t From Teacher t Where t.id Not in (Select c.teacher.id From Course c)")
    List<Teacher>  findTeachersWithoutCourses();

    // Method to count the number of courses taught by a specific teacher
    @Query("Select Count(c) From Course c Where c.teacher.id = :teacherId")
    Long countCoursesByid(Integer teacherId);

    // Method to find a teacher by their first name and last name
    Teacher findByNameAndSurname(String firstName, String lastName);
}
