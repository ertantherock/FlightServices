package com.example.amadeuscasestudy.restcontrollers;


import com.example.amadeuscasestudy.entities.User;
import com.example.amadeuscasestudy.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Api
public class UserRestController {


    final UserService userService;
    final AuthenticationManager authenticationManager;


    @PostMapping("/userSave")
    @ApiOperation(value = "New User adding method")
    public ResponseEntity save(@Valid @RequestBody User user) {

        return userService.saveUser(user);
    }

    @PostMapping("/userLogin")
    @ApiOperation(value = "New user login")
    public ResponseEntity login (@RequestBody User user) throws Exception {
        Authentication authentication;
        try{
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (BadCredentialsException ex){
            throw new Exception("Invalid credentials");
        }

        return new ResponseEntity(user, HttpStatus.OK);
    }



}
