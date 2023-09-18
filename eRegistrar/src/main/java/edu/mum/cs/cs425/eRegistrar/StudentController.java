package edu.mum.cs.cs425.eRegistrar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String listStudents(Model model) {
        // Retrieve a list of all students from the service
        model.addAttribute("students", studentService.getAllStudents());
        return "student-list"; // Return the name of the HTML template (without the .html extension)
    }

    @GetMapping("/add")
    public String showStudentForm(Model model) {
        // Create a new Student object to use in the registration form
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-registration"; // Return the name of the HTML template
    }

    @PostMapping("/add")
    public String registerStudent(@ModelAttribute("student") Student student) {
        // Add code to save the student to the database using the service
        studentService.registerStudent(student);
        return "redirect:/students"; // Redirect to the student list page after registration
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        // Retrieve the student by ID and add it to the model for editing
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student-edit"; // Return the name of the HTML template
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student) {
        // Add code to update the student's data in the database using the service
        studentService.updateStudent(id, student);
        return "redirect:/students"; // Redirect to the student list page after editing
    }

    @GetMapping("/delete/{id}")
    public String showDeleteConfirmation(@PathVariable("id") Long id, Model model) {
        // Retrieve the student by ID and add it to the model for deletion confirmation
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student-delete"; // Return the name of the HTML template
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        // Add code to delete the student from the database using the service
        studentService.deleteStudent(id);
        return "redirect:/students"; // Redirect to the student list page after deletion
    }

    // Add search functionality here if needed
}
