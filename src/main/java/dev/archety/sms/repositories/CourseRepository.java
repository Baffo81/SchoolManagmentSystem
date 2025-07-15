package dev.archety.sms.repositories;

import dev.archety.sms.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// This interface extends JpaRepository to provide CRUD operations for the Course entity.
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    // Custom query to find courses by the teacher's ID
    @Query("Select c From Course c Where c.teacher.id = :id")
    List<Course> findCourseByTeacherId(int id);

    // Custom query to find courses by the student's ID
    @Query("Select Count(c) From Course c Where c.id = :courseId")
    Long countStudentsInCourse(int courseId);

    // Custom query to find courses with more than a specified number of students
    @Query("SELECT c FROM Course c WHERE SIZE(c.students) > :minStudents")
    List<Course> findCoursesWithMoreThanXStudents(int minStudents);

    // Custom query to find courses with no students enrolled
    @Query("SELECT c FROM Course c WHERE c.students IS EMPTY")
    List<Course> findCoursesWithNoStudents();


}
