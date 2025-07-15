package dev.archety.sms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity // Indicates that this class is an entity and is mapped to a database table
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@Table(name="teachers") // Maps this class to the "teachers" table in the database
public class Teacher {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing primary key
    @Column(name = "teach_id") // Maps this field to the "teach_id" column in the database
    private int id;

    @Column(name="firstName")
    private String name; // Teacher's first name
    @Column(name="lastName")
    private String surname; // Teacher's last name
    @Column(name="email")
    private String email; // Teacher's email address
    @Column(name="teach_cod")
    private String teacherCode; // Unique code for the teacher
    private String teachingSubject; // Subject that the teacher teaches

    @OneToMany(mappedBy = "teacher") // One-to-many relationship with Course, mapped by the "teacher" field in Course)
    @JsonIgnore // Prevents serialization of this field to JSON to avoid circular references
    private List<Course> courses; // List of courses taught by the teacher
}
