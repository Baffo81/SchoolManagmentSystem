package dev.archety.sms.exceptions;
// Exception class for handling cases where a student is not found
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
