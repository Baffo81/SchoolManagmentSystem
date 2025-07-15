package dev.archety.sms.services;

import dev.archety.sms.exceptions.StudentNotFoundException;
import dev.archety.sms.exceptions.TeacherException;
import dev.archety.sms.models.Student;
import dev.archety.sms.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// This class is a placeholder for future service methods related to Student operations.
@Service
public class StudentService {

    // This annotation allows Spring to automatically inject the StudentRepository bean.
    @Autowired
    private StudentRepository studentRepository;

    // This method retrieves all students from the repository.
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        if (students.isEmpty()) {
            throw new TeacherException("Nessun insegnante presente nel sistema.");
        }
        return students;
    }

    // This method retrieves a student by their ID.
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Studente con id " + id + " non trovato"));
    }

    // This method saves a student to the repository.
    public Student saveStudent(Student student) {
        if (student == null) {
            throw new StudentNotFoundException("Dati studente non validi.");
        }
        return studentRepository.save(student);
    }

    // This method deletes a student by their ID.
    public void deleteStudent(Integer id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Impossibile eliminare: studente con ID " + id + " non esiste.");
        }
        studentRepository.deleteById(id);
    }

    // Method to find students by last name
    public List<Student> findByFirstName(String firstName) {
        List<Student> students = studentRepository.findByfirstName(firstName);
        if (students == null || students.isEmpty()) {
            throw new StudentNotFoundException("Nessuno studente trovato con nome: " + firstName);
        }
        return students;
    }

    // Method to find students by substring in last name
    public List<Student> findByLastNameContaining(String substring) {
        List<Student> students = studentRepository.findBylastNameContaining(substring);
        if (students == null || students.isEmpty()) {
            throw new StudentNotFoundException("Nessuno studente trovato con cognome contenente: " + substring);
        }
        return students;
    }

    // Method to find students by domain in email
    public List<Student> findByEmail(String domain) {
        List<Student> students = studentRepository.findByEmail(domain);
        if (students == null || students.isEmpty()) {
            throw new StudentNotFoundException("Nessuno studente trovato con dominio email: " + domain);
        }
        return students;
    }

    // Method to find all students ordered by last name in ascending order
    public List<Student> findAllOrderByLastNameAsc() {
        List<Student> students = studentRepository.findALLOrderByLastNameAsc();
        if (students == null || students.isEmpty()) {
            throw new StudentNotFoundException("Nessuno studente presente nel sistema.");
        }
        return students;
    }

    // Method to count the number of courses a student is enrolled in by their ID
    public Long countCoursesByStudentID(Integer studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException("Studente con id " + studentId + " non trovato.");
        }
        return studentRepository.countCoursesByStudentID(studentId);
    }
}
