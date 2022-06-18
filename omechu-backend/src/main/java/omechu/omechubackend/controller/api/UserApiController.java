package omechu.omechubackend.controller.api;

import lombok.RequiredArgsConstructor;
import omechu.omechubackend.entity.User;
import omechu.omechubackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private UserService userService;

    @PostMapping("/api/user")
    public ResponseEntity<?> saveMember(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED ); // 201
    }
}
