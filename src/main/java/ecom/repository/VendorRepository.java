package ecom.repository;

import ecom.domain.Vendor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VendorRepository {
    private SessionFactory sessionFactory;

    public VendorRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Vendor> list() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Vendor> departmentQuery = session.createQuery("from Vendor", Vendor.class);
        return departmentQuery.getResultList();
    }

    public boolean create(Vendor vendor) {
        Session session = sessionFactory.getCurrentSession();
        session.save(vendor);
        return true;
    }

    public Vendor get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Vendor.class, id);
    }

    public boolean update(Vendor vendor) {
        Session session = sessionFactory.getCurrentSession();
        session.update(vendor);
        return true;
    }

    public boolean delete(Vendor vendor) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(vendor);
        return true;
    }
}
