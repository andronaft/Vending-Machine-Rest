package com.zuk.service.impl;

import com.zuk.model.Role;
import com.zuk.model.enums.Status;
import com.zuk.model.User;
import com.zuk.repository.RoleRepository;
import com.zuk.repository.UserRepository;
import com.zuk.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository,  RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;

        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;

    }

//    @Override
//    public User register(User user) {
//        Role roleUser = roleRepository.findByName("ROLE_USER");
//        List<Role> userRoles = new ArrayList<>();
//        userRoles.add(roleUser);
//
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRoles(userRoles);
//        user.setStatus(Status.ACTIVE);
//
//        User registeredUser = userRepository.save(user);
//
//        log.info("IN register - user: {} successfully registered", registeredUser.getUsername());
//
//        return registeredUser;
//    }
//
//
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
//
//    @Override
//    public User findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }




//    @Override
//    public Boolean checkUsername(String username) {
//        return userRepository.findByUsername(username) != null;
//    }
//
//    @Override
//    public Boolean checkEmail(String email) {
//        return userRepository.findByEmail(email) != null;
//    }
//
//
//
//    @Override
//    public User updatePassword(String password,Long id) {
//        User user = userRepository.getOne(id);
//        user.setPassword(passwordEncoder.encode(password));
//        return userRepository.save(user);
//    }



//    @Override
//    public void delete(Long id) {
//        userRepository.deleteById(id);
//        log.info("IN delete - user with id: {} successfully deleted",id);
//    }


}