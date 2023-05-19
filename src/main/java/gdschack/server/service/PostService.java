package gdschack.server.service;

import gdschack.server.domain.Post;
import gdschack.server.domain.User;
import gdschack.server.dto.request.PostCreateDto;
import gdschack.server.dto.response.PostResponse;
import gdschack.server.repository.PostRepository;
import gdschack.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

//    public PostResponse createPost(PostCreateDto postCreateDto){
//
//        return  postCreateDto;
//    }
}
