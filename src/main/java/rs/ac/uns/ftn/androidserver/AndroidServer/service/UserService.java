package rs.ac.uns.ftn.androidserver.AndroidServer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.androidserver.AndroidServer.dto.LoginParams;
import rs.ac.uns.ftn.androidserver.AndroidServer.dto.UserDTO;
import rs.ac.uns.ftn.androidserver.AndroidServer.model.User;
import rs.ac.uns.ftn.androidserver.AndroidServer.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findOneById(Integer id) {
        return userRepository.findOneById(id);
    }

    public List<UserDTO> findAll() {

        List<User> userList = userRepository.findAll();
        List<UserDTO> dtoList = new ArrayList<UserDTO>();

        for (User u : userList) {
            UserDTO dto = new UserDTO();
            dto.setId(u.getId());
            dto.setEmail(u.getEmail());
            dto.setFirstName(u.getFirstName());
            dto.setLastName(u.getLastName());
            dto.setPassword(u.getPassword());
            dto.setPhoneNumber(u.getPhoneNumber());

            dtoList.add(dto);
        }

        return dtoList;
    }

    public User registerUser(UserDTO user) {

        List<User> users = userRepository.findAll();
        for (User u : users) {
            if (u.getEmail().equals(user.getEmail())) {
                System.out.println("E-mail in use..");
                return null;
            }
        }

        User u = new User();
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setEmail(user.getEmail());
        u.setPhoneNumber(user.getPhoneNumber());
        u.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(u);

        return u;

    }

    public User findOneByEmail(String email) {

        List<User> userList = userRepository.findAll();

        for (User u : userList) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<User> userList = userRepository.findAll();

        for (User u : userList) {
            if (u.getEmail().equals(email)) {

                return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(),
                        new ArrayList<>());
            }
        }
        return null;

    }

}
