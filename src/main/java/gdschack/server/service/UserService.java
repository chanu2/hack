package gdschack.server.service;

import gdschack.server.domain.User;
import gdschack.server.dto.request.UserCreateDto;
import gdschack.server.dto.response.LoginCheck;
import gdschack.server.dto.response.UserResponse;
import gdschack.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserResponse createUser(UserCreateDto userCreateDto) {
        User user = userRepository.save(userCreateDto.toEntity());
        return new UserResponse(user);
    }

    public UserResponse findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new NullPointerException());
        return new UserResponse(user);
    }

    public UserResponse findUserByLoginId(String loginId) {
        User user = userRepository.findByLoginId(loginId)
                .orElseThrow(()-> new RuntimeException("error"));
        return new UserResponse(user);
    }

    public LoginCheck checkUser(String LoginId) {
        LoginCheck loginCheck = new LoginCheck(userRepository.existsByLoginId(LoginId));
        return loginCheck;
    }

    public List<UserResponse> findAllTeacherByName(String name) {
        List<User> userList = userRepository.findAllByNameContainsAndStatus(name, "선생님");
        return  userList.stream().map(u-> new UserResponse(u)).collect(Collectors.toList());
    }


}
