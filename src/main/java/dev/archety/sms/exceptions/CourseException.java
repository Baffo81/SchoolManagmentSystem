package dev.archety.sms.exceptions;

// This class defines a custom exception for course-related errors in the application.
public class CourseException  extends RuntimeException {
    // Default constructor for CourseException.
    public CourseException(String message) {
        super(message);
    }
}
