package ecom.service;

import ecom.domain.Student;
import ecom.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class StudentService {

    private Logger logger = Logger.getLogger(StudentService.class.getName());

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> list() {
        return studentRepository.list();
    }

    public Student get(Long id) {
        return studentRepository.get(id);
    }

    public boolean create(Student student) {
        return studentRepository.create(student);
    }

    public boolean update(Student student) {
        return studentRepository.update(student);
    }

    public boolean delete(Long id) {
        return studentRepository.delete(get(id));
    }
}
