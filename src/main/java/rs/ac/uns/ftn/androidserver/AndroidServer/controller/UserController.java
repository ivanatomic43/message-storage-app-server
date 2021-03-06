package rs.ac.uns.ftn.androidserver.AndroidServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.androidserver.AndroidServer.dto.UserDTO;
import rs.ac.uns.ftn.androidserver.AndroidServer.model.User;
import rs.ac.uns.ftn.androidserver.AndroidServer.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // change
    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAll() {

        List<UserDTO> userList = userService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

}
