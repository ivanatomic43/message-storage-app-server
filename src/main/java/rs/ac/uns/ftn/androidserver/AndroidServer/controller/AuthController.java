package rs.ac.uns.ftn.androidserver.AndroidServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.androidserver.AndroidServer.dto.LoginParams;
import rs.ac.uns.ftn.androidserver.AndroidServer.dto.UserDTO;
import rs.ac.uns.ftn.androidserver.AndroidServer.model.User;
import rs.ac.uns.ftn.androidserver.AndroidServer.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO user) {
        System.out.println("PRONASAO REGISTER NA BEKu");

        User myUser = userService.registerUser(user);

        if (myUser == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(myUser, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginParams loginParams) {

        LoginParams params = userService.login(loginParams);

        if (params == null) {
            System.out.println("Wrong username or password!");
            return new ResponseEntity<>(params, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(params, HttpStatus.OK);

    }

}
