package dev.archety.sms.controllers;

import dev.archety.sms.models.Teacher;
import dev.archety.sms.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    // Endpoint to find all teachers
    @GetMapping( )
    List<Teacher> findAllTeachers() {
        return teacherService.findAllTeachers();
    }

    // Endpoint to find teachers by their subject of teaching
    @GetMapping("/search-subject/{subject}")
    List<Teacher> findByTeachingSubjectController(@PathVariable String subject) {
        return teacherService.findByTeachingSubjectService(subject);
    }
    // Endpoint to find teachers who are teaching at least one course
    @GetMapping("/with-courses")
    List<Teacher> findTeachersWithLeastOneCourse() {
        return teacherService.findTeachersWithLeastOneCourseService();
    }
    // Endpoint to find teachers who are not teaching any courses
    @GetMapping("/without-courses")
    List<Teacher> findTeachersWithoutCourses() {
        return teacherService.findTeachersWithoutCoursesService();
    }
    // Endpoint to count the number of courses taught by a specific teacher
    @GetMapping("/{teacherId}/count-courses")
    Long countCoursesByid(@PathVariable Integer teacherId) {
        return teacherService.countCoursesByid(teacherId);
    }
    // Endpoint to find a teacher by their first name and last name
    @GetMapping("/{firstName}/{lastName}")
    Teacher findByfirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
        return teacherService.findByfirstNameAndLastNameService(firstName, lastName);
    }

    // Endpoint to save a Teacher entity
    @PostMapping("/save")
    Teacher saveTeacher(Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }

    // Endpoint to delete a Teacher entity by its ID
    @DeleteMapping("/{id}")
    boolean deleteTeacher(@PathVariable int id) {
        return teacherService.deleteTeacher(id);
    }
    // Endpoint to find a Teacher entity by its ID
    @GetMapping("/{id}")
    Teacher findById(@PathVariable int id) {
        return teacherService.findById(id);
    }
}
