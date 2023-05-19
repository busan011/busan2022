package com.example.demo;

import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class AuthController {

  private final AuthService authService;

  /*
  * 회원가입
  * */
  @PostMapping("/signup")
  public ResponseEntity registerUser(@RequestBody UserDto userDto) {
	  System.out.println(userDto);
    if(authService.existsByUsername(userDto.getEmail())) {
//      return ResponseEntity.ok(Result.fail("유저가 존재합니다."));
      return ResponseEntity.ok("유저가 존재합니다.");
    }

    UserDto result = authService.createUser(userDto);
//    return ResponseEntity.ok(Result.success(result));
    return ResponseEntity.ok(result);
  }

  /*
  *  로그인
  * */
  @PostMapping(path = "/signin")
  public ResponseEntity<?> authenticateUser(@RequestBody  UserDto userDto) {

    AccessTokenResponse response = authService.setAuth(userDto);
//    return ResponseEntity.ok(Result.success(response));
    return ResponseEntity.ok(response);
  }
}





