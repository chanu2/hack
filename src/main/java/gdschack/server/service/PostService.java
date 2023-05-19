package gdschack.server.service;

import gdschack.server.domain.Post;
import gdschack.server.domain.User;
import gdschack.server.dto.request.PostCreateDto;
import gdschack.server.dto.response.PostResponse;
import gdschack.server.repository.PostRepository;
import gdschack.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostResponse createPost(PostCreateDto postCreateDto){

        User user = userRepository.findByLoginId(postCreateDto.getLoginId());

        log.info("user={}",user.getName());

        Post post = Post.builder()
                .user(user)
                .writer(postCreateDto.getWriter())
                .content(postCreateDto.getContent())
                .teacherLoginId(postCreateDto.getTeacherLoginId())
                .build();

        postRepository.save(post);

        return new PostResponse(post);
    }


}
