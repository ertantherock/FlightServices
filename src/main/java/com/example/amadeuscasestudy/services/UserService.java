package com.example.amadeuscasestudy.services;

import com.example.amadeuscasestudy.configs.Rest;
import com.example.amadeuscasestudy.entities.Role;
import com.example.amadeuscasestudy.entities.User;
import com.example.amadeuscasestudy.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    final UserRepository userRepository;
    final PasswordEncoder passwordEncoder;

    public ResponseEntity<User> saveUser(User user) {

        try {
            Optional<User> optionalUser = userRepository.findByEmailEqualsIgnoreCase(user.getEmail());
            if (optionalUser.isPresent()) {
                Rest rest = new Rest(false, "User Already Exists");
                return new ResponseEntity(rest, HttpStatus.BAD_REQUEST);
            } else {
                String newPassword = passwordEncoder.encode(user.getPassword());
                user.setPassword(newPassword);
                userRepository.save(user);
                Rest rest = new Rest(true, user);
                return new ResponseEntity(rest, HttpStatus.OK);
            }
        } catch (Exception ex) {
            Rest rest = new Rest(false, ex.getMessage());
            return new ResponseEntity(rest, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmailEqualsIgnoreCase(username);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),parseRole(user.getRoles()));
        }
        throw  new UsernameNotFoundException("Not Found");
    }

    private Collection<? extends GrantedAuthority> parseRole(List<Role> roles) {
        List<GrantedAuthority> ls = new ArrayList<>();
        for(Role item : roles){
            ls.add(new SimpleGrantedAuthority(item.getName()));
        }
        return ls;
    }
}
