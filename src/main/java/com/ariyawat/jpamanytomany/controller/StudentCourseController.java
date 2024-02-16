package com.ariyawat.jpamanytomany.controller;

import com.ariyawat.jpamanytomany.entity.Course;
import com.ariyawat.jpamanytomany.entity.Student;
import com.ariyawat.jpamanytomany.repository.CourseRepository;
import com.ariyawat.jpamanytomany.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students/course")
public class StudentCourseController {
    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    public StudentCourseController(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @PostMapping
    public Student saveStudentWithCourse(@RequestBody Student student) {
        return studentRepository.save(student);
    }
    @GetMapping
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }
    @GetMapping("/{studentId}")
    public Student findStudent(@PathVariable Long studentId){
        return studentRepository.findById(studentId).orElse(null);
    }
    @GetMapping("/find/{name}")
    public List<Student> findStudentsContainingByName(@PathVariable String name){
        return studentRepository.findByNameContaining(name);
    }
    @GetMapping("/search/{price}")
    public List<Course> findCourseLessThanPrice(@PathVariable double price){
        return courseRepository.findByFeeLessThan(price);
    }
}
