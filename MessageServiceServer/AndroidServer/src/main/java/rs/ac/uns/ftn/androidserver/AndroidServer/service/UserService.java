package rs.ac.uns.ftn.androidserver.AndroidServer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.androidserver.AndroidServer.dto.LoginParams;
import rs.ac.uns.ftn.androidserver.AndroidServer.dto.UserDTO;
import rs.ac.uns.ftn.androidserver.AndroidServer.model.User;
import rs.ac.uns.ftn.androidserver.AndroidServer.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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
        u.setPassword(user.getPassword());
        userRepository.save(u);

        return u;

    }

    // edit this, insert token
    public LoginParams login(LoginParams login) {

        List<User> userList = userRepository.findAll();

        for (User u : userList) {
            System.out.println(u.getEmail());
            System.out.println(u.getPassword());
            System.out.println(login.getEmail());
            System.out.println(login.getPassword());
            if (u.getEmail().equals(login.getEmail()) && u.getPassword().equals(login.getPassword())) {
                LoginParams params = new LoginParams();
                params.setEmail(u.getEmail());
                params.setAccessToken(u.getPassword());

                return params;
            }
        }

        return null;

    }
}
