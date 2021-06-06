package rs.ac.uns.ftn.androidserver.AndroidServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.androidserver.AndroidServer.dto.LoginParams;
import rs.ac.uns.ftn.androidserver.AndroidServer.dto.UserDTO;
import rs.ac.uns.ftn.androidserver.AndroidServer.model.User;
import rs.ac.uns.ftn.androidserver.AndroidServer.service.UserService;
import rs.ac.uns.ftn.androidserver.AndroidServer.utils.TokenUtils;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

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
    public ResponseEntity<?> login(@RequestBody LoginParams loginParams) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginParams.getEmail(), loginParams.getPassword()));

        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password.", e);
        }

        final UserDetails userDetails = userService.loadUserByUsername(loginParams.getEmail());
        final String jwt = tokenUtils.generateToken(userDetails);

        LoginParams ret = new LoginParams(loginParams.getEmail(), jwt);

        return new ResponseEntity<>(ret, HttpStatus.OK);

    }

}
