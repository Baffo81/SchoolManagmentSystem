package dev.archety.sms.services;

import dev.archety.sms.exceptions.CourseException;
import dev.archety.sms.models.Course;
import dev.archety.sms.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// This service class provides business logic for managing courses.
@Service
public class CourseService {

    // Autowired annotation is used to inject the CourseRepository dependency.
    @Autowired
    private CourseRepository courseRepository;

    // This method retrieves all courses from the repository.
    public List<Course> findAllCourses() {
        List<Course> courses = courseRepository.findAll();
        if (courses == null || courses.isEmpty()) {
            throw new CourseException("Nessun corso presente nel sistema.");
        }
        return courses;
    }

    // This method retrieves a course by its ID from the repository.
   public List<Course> findCourseByTeacherIdService(int id) {
       List<Course> courses = courseRepository.findCourseByTeacherId(id);
       if (courses == null || courses.isEmpty()) {
           throw new CourseException("Nessun corso trovato per l'insegnante con id: " + id);
       }
       return courses;
    }

    // This method counts the number of students enrolled in a specific course.
   public Long countStudentsInCourseService(int courseId) {
       if (!courseRepository.existsById(courseId)) {
           throw new CourseException("Corso con id " + courseId + " non trovato.");
       }
       return courseRepository.countStudentsInCourse(courseId);
    }

    // This method retrieves courses with more than a specified number of students.
    public List<Course> findCoursesWithMoreThanXStudentsService(int minStudents) {
        List<Course> courses = courseRepository.findCoursesWithMoreThanXStudents(minStudents);
        if (courses == null || courses.isEmpty()) {
            throw new CourseException("Nessun corso trovato con più di " + minStudents + " studenti.");
        }
        return courses;
     }

    // This method retrieves courses that have no students enrolled.
    public List<Course> findCoursesWithNoStudentsService() {
        List<Course> courses = courseRepository.findCoursesWithNoStudents();
        if (courses == null || courses.isEmpty()) {
            throw new CourseException("Tutti i corsi hanno almeno uno studente.");
        }
        return courses;
    }

    // This method saves a course to the repository.
    public Course saveCourse(Course course) {
        if (course == null) {
            throw new CourseException("Dati corso non validi.");
        }
        return courseRepository.save(course);
    }

    // This method deletes a course by its ID from the repository.
    public void deleteCourseById(int id) {
        if (!courseRepository.existsById(id)) {
            throw new CourseException("Impossibile eliminare: corso con id " + id + " non trovato.");
        }
        courseRepository.deleteById(id);
    }

    // This method retrieves a course by its ID from the repository.
    public Course findCourseById(int id) {
        return courseRepository.findById(id).orElseThrow(() ->
            new CourseException("Corso con id " + id + " non trovato."));
    }

}
