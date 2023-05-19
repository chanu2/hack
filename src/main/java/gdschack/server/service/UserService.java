package gdschack.server.service;

import gdschack.server.domain.User;
import gdschack.server.dto.request.UserCreateDto;
import gdschack.server.dto.response.UserResponse;
import gdschack.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        User user = userRepository.findByLoginId(loginId);
        return new UserResponse(user);
    }

}
