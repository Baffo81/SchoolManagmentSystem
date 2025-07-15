package dev.archety.sms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity // Indicates that this class is an entity and is mapped to a database table
@Table(name="students") // Maps this class to the "students" table in the database
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor // Lombok annotations to generate boilerplate code
public class Student {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing primary key
    @Column(name = "stud_id") // Maps this field to the "id" column in the database
    private int id;
    private String firstName; // Student's name
    private String lastName; // Student's surname
    private String email; // Student's email
    @Column(name="matricola")
    private String matriculationNumber; // Student's matriculation number

    @ManyToMany(mappedBy = "students") // Many-to-many relationship with Course, mapped by the "students" field in Course
    @JsonIgnore // Prevents this field from being serialized to JSON to avoid infinite recursion
    private List<Course> courses; // List of courses the student is enrolled in

}
