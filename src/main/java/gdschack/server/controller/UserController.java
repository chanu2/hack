package gdschack.server.controller;

import gdschack.server.dto.request.SignInDto;
import gdschack.server.dto.request.UserCreateDto;
import gdschack.server.dto.response.LoginCheck;
import gdschack.server.dto.response.UserResponse;
import gdschack.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public UserResponse postResponse(@RequestBody UserCreateDto userCreateDto){
        return userService.createUser(userCreateDto);
    }

    @GetMapping("/{loginId}/exists")
    public LoginCheck userChecked(@PathVariable String loginId) {
        return userService.checkUser(loginId);
    }

    @GetMapping("/signin")
    public UserResponse login(@RequestBody SignInDto signInDto) {
        return userService.findUserByLoginId(signInDto.getLoginId());
    }

    @GetMapping("/search/teacher/{name}")
    public List<UserResponse> searchTeacher(@PathVariable String name) {
        return userService.findAllTeacherByName(name);
    }


}
