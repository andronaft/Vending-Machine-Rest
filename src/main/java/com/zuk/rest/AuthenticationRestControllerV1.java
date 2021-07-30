package com.zuk.rest;

import com.zuk.dto.auth.AuthenticationRequestDto;

import com.zuk.model.User;
import com.zuk.security.JwtTokenProvider;
import com.zuk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;



@RestController
@RequestMapping(value = "/api/v1/auth/")
public class AuthenticationRestControllerV1 {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;



    @Autowired
    public AuthenticationRestControllerV1(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;

    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();
            User user = userService.findByUsername(username);
            System.out.println(user == null);

            if (user == null) {
                System.out.println("return");

                throw new BadCredentialsException("Invalid username or password");

            }

                System.out.println("try");

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("user_id",user.getId());
            response.put("role",jwtTokenProvider.getRoleNames(user.getRoles()));
            response.put("token", token);
            System.out.println(response);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
               // throw  new UsernameNotFoundException("User  not found");
                //
            throw new BadCredentialsException("Invalid username or password");
        }
    }




}