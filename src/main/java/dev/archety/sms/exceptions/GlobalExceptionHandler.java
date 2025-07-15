package dev.archety.sms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Global exception handler for the application
@RestControllerAdvice
public class GlobalExceptionHandler {
    // Handle StudentNotFoundException and return a 404 Not Found response
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    // Handle TeacherException and return a 404 Not Found response
    @ExceptionHandler(TeacherException.class)
    public ResponseEntity<String> handleTeacherException(TeacherException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // Handle CourseException and return a 404 Not Found response
    @ExceptionHandler(CourseException.class)
    public ResponseEntity<String> handleCourseException(CourseException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}