package dev.archety.sms.controllers;

import dev.archety.sms.models.Student;
import dev.archety.sms.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This annotation indicates that this class is a REST controller, which will handle HTTP requests.
@RequestMapping("api/students") // This annotation maps HTTP requests to /api/students to this controller.
public class StudentController {
    // This annotation allows Spring to automatically inject the StudentService bean.
    @Autowired
    private StudentService studentService;

    // This method handles GET requests to /api/students and returns a list of all students.
    @GetMapping( )
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // This method handles GET requests to /api/students/{id} and returns a student by their ID.
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    // This method handles Post requests to /api/students/addStudent and returns a response.
    @PostMapping("/addStudent")
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // This method handles Put requests to /api/students/updateStudent/{id} and updates a student by their ID.
    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        student.setId(id);
        return studentService.saveStudent(student);
    }

    // This method handles Delete requests to /api/students/{id} and deletes a student by their ID.
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }

    // This method handles Get request to /api/students/{id}/courses/count and returns the count of courses a student is enrolled in by their ID.
    @GetMapping("/{id}/courses/count")
    public Long countCoursesByStudentId(@PathVariable Integer id) {
        return studentService.countCoursesByStudentID(id);
    }

    // This method handles Get requests to /api/students/search/firstName/{firstName} and returns a list of students with the specified first name.
    @GetMapping("/search/firstName/{firstName}")
    public List<Student> findByFirstName(@PathVariable String firstName) {
        return studentService.findByFirstName(firstName);
    }

    // This method handles Get requests to /api/students/search/lastName/{substring} and returns a list of students whose last name contains the specified substring.
    @GetMapping("/search/lastName/{substring}")
    public List<Student> findByLastNameContaining(@PathVariable String substring) {
        return studentService.findByLastNameContaining(substring);
    }

    // This method handles Get requests to /api/students/search/email/{domain} and returns a list of students with the specified email domain.
    @GetMapping("/search/email/{domain}")
    public List<Student> findByEmail(@PathVariable String domain) {
        return studentService.findByEmail(domain);
    }
    // This method handles Get requests to /api/students/sort/lastName and returns a list of all students ordered by last name in ascending order.
    @GetMapping("/sort/lastName")
    public List<Student> findAllOrderByLastNameAsc() {
        return studentService.findAllOrderByLastNameAsc();
    }

}
