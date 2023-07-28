package ecom.service;

import ecom.domain.ChangePassword;
import ecom.domain.ForgotPassword;
import ecom.domain.SignIn;
import ecom.domain.User;
import ecom.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class UserService {

    private Logger logger = Logger.getLogger(UserService.class.getName());

    private UserRepository userRepository;

    private VendorService vendorService;

    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, VendorService vendorService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.vendorService = vendorService;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> list() {
        return userRepository.list();
    }

    public boolean create(User user) {
        return userRepository.create(user);
    }

    public boolean update(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.update(user);
    }

    public User userGet(Long userId) {
        return userRepository.userGet(userId);
    }

    public boolean logIn(SignIn signIn) {
        return userRepository.logIn(signIn.getUsername(), signIn.getPassword());
    }

    public boolean searchUserForForgotPassword(ForgotPassword forgotPassword) {
        return userRepository.searchUser(forgotPassword.getUsername());
    }

    public boolean searchUserForChangePassword(ChangePassword changePassword) {
        return userRepository.searchUserPassword(changePassword.getUsername(), changePassword.getCurrent_password());
    }

    public boolean checkUser(User user) {
        return userRepository.searchUser(user.getUsername());
    }

    public boolean updatePasswordForForgotPassword(ForgotPassword forgotPassword) {
        return userRepository.updatePasswordForForgotPassword(forgotPassword);
    }

    public boolean updatePasswordForChangePassword(ChangePassword changePassword) {
        return userRepository.updatePasswordForChangePassword(changePassword);
    }

    public User get(String username) {
        return userRepository.get(username);
    }
}
