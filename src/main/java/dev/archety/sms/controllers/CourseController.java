package dev.archety.sms.controllers;

import dev.archety.sms.models.Course;
import dev.archety.sms.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This controller handles HTTP requests related to courses.
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    // Autowired annotation is used to inject the CourseService dependency.
    @Autowired
    private CourseService courseService;

    // This method retrieves all courses by calling the service method.
    @GetMapping( )
    List<Course> findAllCourses() {
        return courseService.findAllCourses();
    }

    // This method retrieves courses by its ID.
    @GetMapping("/{id}")
    Course findCourseById(@PathVariable int id) {
        return courseService.findCourseById(id);
    }

    // This method retrieves courses by the teacher's ID.
    @PostMapping("/save-course")
    Course saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    // This method retrieves courses by the teacher's ID.
    @DeleteMapping("/delete-course/{id}")
    void deleteCourseById(@PathVariable int id) {
        courseService.deleteCourseById(id);
    }

    // This method retrieves courses by the teacher's ID.
    @GetMapping("/teacher/{id}")
    List<Course> findCourseByTeacherId(@PathVariable int id) {
        return courseService.findCourseByTeacherIdService(id);
    }

    // This method counts the number of students in a specific course.
    @GetMapping("/count-students/{courseId}")
    Long countStudentsInCourse(@PathVariable int courseId) {
        return courseService.countStudentsInCourseService(courseId);
    }

    // This method retrieves courses with more than a specified number of students.
    @GetMapping("/more-than/{minStudents}")
    List<Course> findCoursesWithMoreThanXStudents(@PathVariable int minStudents) {
        return courseService.findCoursesWithMoreThanXStudentsService(minStudents);
    }

    // This method retrieves courses that have no students enrolled.
    @GetMapping("/no-students")
    List<Course> findCoursesWithNoStudents() {
        return courseService.findCoursesWithNoStudentsService();
    }

}
