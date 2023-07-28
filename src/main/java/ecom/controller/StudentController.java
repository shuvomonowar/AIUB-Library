package ecom.controller;

import ecom.domain.Student;
import ecom.service.StudentService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
//import  org.apache.log4j.Logger;

@Controller
@RequestMapping("/students")
public class StudentController {
    private static final Logger logger = Logger.getLogger(BookController.class.getName());

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException
            {
                LocalDate localDate = LocalDate.parse(text, dateFormatter);
                setValue(localDate);
            }
        });
    }

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("students", studentService.list());
        return "student/list";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("student", new Student());
        return "student/create";
    }

    @RequestMapping("/store")
    public String store(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "student/create";
        }
        student.setCreatedOn(LocalDate.now());
        studentService.create(student);
        return "redirect:/students/list";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("studentId") Long studentId, Model model) {
        model.addAttribute("student", studentService.get(studentId));

        logger.log(Level.SEVERE, "\"SQL exception occurred while accessing StudentService");
        logger.log(Level.SEVERE, "\"SQL exception occurred while accessing StudentRepository");

        //logger.debug("Debug." + studentId);
        logger.info("Info." + studentId);
        logger.warning("Warning" + "studentId must be long type");

        return "student/edit";
    }

    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "student/edit";
        }
        student.setCreatedOn(LocalDate.now());
        studentService.update(student);
        return "redirect:/students/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("studentId") Long studentId) {
        studentService.delete(studentId);

        logger.log(Level.SEVERE, "\"SQL exception occurred while accessing StudentService");
        logger.log(Level.SEVERE, "\"SQL exception occurred while accessing StudentRepository");

        logger.info("Info." + studentId);
        logger.warning("Warning" + "studentId must be long type");

        return "redirect:/students/list";
    }
}
