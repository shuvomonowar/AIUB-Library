package ecom.repository;

import ecom.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class StudentRepository {
    private SessionFactory sessionFactory;

    public StudentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Student> list() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Student> studentTypedQuery = session.createQuery("from Student", Student.class);
        return studentTypedQuery.getResultList();
    }

    public boolean create(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
        return true;
    }

    public Student get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    public boolean update(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.update(student);
        return true;
    }

    public boolean delete(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(student);
        return true;
    }
}
