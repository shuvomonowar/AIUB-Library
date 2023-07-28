package ecom.repository;

import ecom.domain.ChangePassword;
import ecom.domain.ForgotPassword;
import ecom.domain.SignIn;
import ecom.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepository {
    private SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> list() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<User> userQuery = session.createQuery("from User", User.class);
        return userQuery.getResultList();
    }

    public boolean logIn(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<User> userQuery = session.createQuery("from User Where username = :username And password = :password", User.class);
        userQuery.setParameter("username", username);
        userQuery.setParameter("password", password);
        List<User> list = userQuery.getResultList();
        return list != null && !list.isEmpty();
    }

    public boolean create(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return true;
    }

    public boolean update(User user) {
        /*
        Session session = sessionFactory.getCurrentSession();
        String passwordUpdate = "Update User SET full_name = :full_name, dateOfBirth = :dateOfBirth, gender = :gender, email = :email WHERE username = :username";
        int updateEntities = session.createQuery(passwordUpdate).setParameter("full_name", user.getFullName()).setParameter("dateOfBirth", user.getDateOfBirth()).setParameter("gender", user.getGender()).setParameter("email", user.getEmail()).setParameter("username", user.getUsername())
                .executeUpdate();
        return true;
         */

        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        return true;
    }

    public boolean delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
        return true;
    }

    public User get(String username) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<User> userQuery = session.createQuery("from User Where username = :username And password = :password", User.class);
        userQuery.setParameter("username", username);
        return userQuery.getSingleResult();
    }

    public User userGet(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, userId);
    }

    public boolean searchUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<User> userQuery = session.createQuery("from User Where username = :username", User.class);
        userQuery.setParameter("username", username);
        List<User> list = userQuery.getResultList();
        return list != null && !list.isEmpty();
    }

    public boolean searchUserPassword(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<User> userQuery = session.createQuery("from User Where username = :username AND password = :password", User.class);
        userQuery.setParameter("username", username);
        userQuery.setParameter("password", password);
        List<User> list = userQuery.getResultList();
        return list != null && !list.isEmpty();
    }

    public boolean updatePasswordForForgotPassword(ForgotPassword forgotPassword) {
        Session session = sessionFactory.getCurrentSession();
        String passwordUpdate = "Update User SET password = :password WHERE username = :username";
        int updateEntities = session.createQuery(passwordUpdate).setParameter("password", forgotPassword.getPassword()).setParameter("username", forgotPassword.getUsername())
                .executeUpdate();
        return true;
    }

    public boolean updatePasswordForChangePassword(ChangePassword changePassword) {
        Session session = sessionFactory.getCurrentSession();
        String passwordUpdate = "Update User SET password = :password WHERE username = :username";
        int updateEntities = session.createQuery(passwordUpdate).setParameter("password", changePassword.getNew_password()).setParameter("username", changePassword.getUsername())
                .executeUpdate();
        return true;
    }
}
