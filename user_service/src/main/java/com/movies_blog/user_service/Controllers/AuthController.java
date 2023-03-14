package com.movies_blog.user_service.Controllers;

import com.movies_blog.user_service.Entities.User;
import com.movies_blog.user_service.Models.LoginRequest;
import com.movies_blog.user_service.Models.LoginResponse;
import com.movies_blog.user_service.Services.UserService;
import com.movies_blog.user_service.Utils.JwtTokenUtil;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@NotNull @RequestBody @Valid LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );

            User user = (User) authentication.getPrincipal();
            String accessToken = jwtTokenUtil.generateAccessToken(user);
            LoginResponse response = new LoginResponse(user.getEmail(), accessToken);

            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/auth/create_test")
    public void createTestUser() {
        /*BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("berkay98");
        var roles = new HashSet<Role>();
        roles.add(new Role("User"));

        User newUser = new User("berkay2413", password, "berkay", "aytek", "berkaytek@gmail", true, true, true, true, roles);

        userService.createTestUser(newUser);*/

    }

    @GetMapping("/test/create_test")
    public String testAuthentication() {

        return "You are authorized";
    }


}
