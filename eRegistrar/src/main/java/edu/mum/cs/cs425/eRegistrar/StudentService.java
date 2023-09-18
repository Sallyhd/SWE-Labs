package edu.mum.cs.cs425.eRegistrar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null); // Return null if the student is not found
    }

    public void registerStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Long id, Student updatedStudent) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            // Update the student's data with the new values
            student.setStudentNumber(updatedStudent.getStudentNumber());
            student.setFirstName(updatedStudent.getFirstName());
            student.setMiddleName(updatedStudent.getMiddleName());
            student.setLastName(updatedStudent.getLastName());
            student.setCgpa(updatedStudent.getCgpa());
            student.setEnrollmentDate(updatedStudent.getEnrollmentDate());
            student.setIsInternational(updatedStudent.getIsInternational());
            studentRepository.save(student);
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // Implement additional methods if needed (e.g., search students)
}
