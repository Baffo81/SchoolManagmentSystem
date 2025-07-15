package dev.archety.sms.services;


import dev.archety.sms.exceptions.TeacherException;
import dev.archety.sms.models.Teacher;
import dev.archety.sms.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service class for managing Teacher entities
@Service
public class TeacherService {
    // Autowired annotation to inject the TeacherRepository dependency
    @Autowired
    private TeacherRepository teacherRepository;

    // Method to find teacher by their subject of teaching
   public  List<Teacher> findByTeachingSubjectService(String subject){
       List<Teacher> teachers = teacherRepository.findByTeachingSubject(subject);
       if (teachers == null || teachers.isEmpty()) {
           throw new TeacherException("Nessun insegnante trovato per la materia: " + subject);
       }
       return teachers;
    }

    // Method to find all teachers who are teaching at least one course
    public List<Teacher> findTeachersWithLeastOneCourseService(){
        List<Teacher> teachers = teacherRepository.findTeachersWithLeastOneCourse();
        if (teachers == null || teachers.isEmpty()) {
            throw new TeacherException("Nessun insegnante trovato con almeno un corso.");
        }
        return teachers;
    }

    // Method to find all teachers who are not teaching any courses
    public List<Teacher>  findTeachersWithoutCoursesService(){
        List<Teacher> teachers = teacherRepository.findTeachersWithoutCourses();
        if (teachers == null || teachers.isEmpty()) {
            throw new TeacherException("Tutti gli insegnanti hanno almeno un corso.");
        }
        return teachers;
    }

    // Method to count the number of courses taught by a specific teacher
    public  Long countCoursesByid(Integer teacherId){
        if (!teacherRepository.existsById(teacherId)) {
            throw new TeacherException("Insegnante con id " + teacherId + " non trovato.");
        }
        return teacherRepository.countCoursesByid(teacherId);
    }

    // Method to save a Teacher entity
    public Teacher saveTeacher(Teacher teacher) {
        if (teacher == null) {
            throw new TeacherException("Dati insegnante non validi.");
        }
        return teacherRepository.save(teacher);
    }

    // Method to delete a Teacher entity by its ID
    public  boolean deleteTeacher(int id) {
        if (!teacherRepository.existsById(id)) {
            throw new TeacherException("Impossibile eliminare: insegnante con id " + id + " non trovato.");
        }
        teacherRepository.deleteById(id);
        return true;
    }

    // Method to find a Teacher entity by its ID
    public Teacher findById(int id) {
        return teacherRepository.findById(id).orElseThrow(() -> new TeacherException("Insegnante con id " + id + " non trovato."));
    }

    // Method to find a Teacher entity by its first name and last name
    public Teacher findByfirstNameAndLastNameService(String firstName, String lastName) {
        Teacher teacher = teacherRepository.findByNameAndSurname(firstName, lastName);
        if (teacher == null) {
            throw new TeacherException("Insegnante " + firstName + " " + lastName + " non trovato.");
        }
        return teacher;
    }

    // Method to find all Teacher entities
    public List<Teacher> findAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        if (teachers == null || teachers.isEmpty()) {
            throw new TeacherException("Nessun insegnante presente nel sistema.");
        }
        return teachers;
    }
}
