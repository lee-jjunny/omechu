package omechu.omechubackend.controller;

import lombok.RequiredArgsConstructor;
import omechu.omechubackend.entity.User;
import omechu.omechubackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // security(라이브러리 적용) - CORS 정책을 가지고 있음. (시큐리티가 CORS를 해제해야함)
    // BookController 진입 직전
    @CrossOrigin
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED ); // 201
    }

    @CrossOrigin
    @GetMapping("/user")
    public ResponseEntity<?> findAllUsers(){
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK); // 200
    }

    @CrossOrigin
    @GetMapping("/user/{id}")
    public ResponseEntity<?> findUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.findUser(id), HttpStatus.OK); // 200
    }

    @CrossOrigin
    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK); // 200
    }

    /*@CrossOrigin
    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(memberService.삭제하기(id), HttpStatus.OK); // 200
    }*/
}
