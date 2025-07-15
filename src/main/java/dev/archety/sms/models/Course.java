package dev.archety.sms.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity // Indicates that this class is an entity and is mapped to a database table
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@Table(name="courses") // Maps this class to the "courses" table in the database
public class Course {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing primary key
    @Column(name="cours_id") // Maps this field to the "course_id" column in the database)
    private int id;

    @Column(name="coursName")
    private String name; // Course name

    @ManyToOne // Many-to-one relationship with Teacher
    @JoinColumn(name="teacher_id")
    private Teacher teacher; // ID of the teacher associated with the course

    @ManyToMany // Many-to-many relationship with Student
    @JoinTable(
        name = "Enrollments", // Join table name
        joinColumns = @JoinColumn(name = "course_id"), // Column in the join table that refers to the course
        inverseJoinColumns = @JoinColumn(name = "student_id") // Column in the join table that refers to the student
    )
    private List<Student> students;
}
