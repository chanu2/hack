package gdschack.server.service;

import gdschack.server.domain.Post;
import gdschack.server.domain.User;
import gdschack.server.dto.request.DetailPostDto;
import gdschack.server.dto.request.PostCreateDto;
import gdschack.server.dto.request.UpdatePostDto;
import gdschack.server.dto.response.PostResponse;
import gdschack.server.repository.PostRepository;
import gdschack.server.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostResponse createPost(PostCreateDto postCreateDto){

        User user = userRepository.findByLoginId(postCreateDto.getLoginId()).get();

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

    public PostResponse detailPost(DetailPostDto detailPostDto){

        Post post = postRepository.findById(detailPostDto.getPostId()).orElseThrow(() -> new RuntimeException("없는 포스트"));

        if(post.getTeacherLoginId().equals(detailPostDto.getLoginId())){
            post.setCheckRead(true);
        }

        return new PostResponse(post);
    }

    public PostResponse updatePost(UpdatePostDto updatePostDto){

        User user = userRepository.findByLoginId(updatePostDto.getLoginId()).orElseThrow(() -> new RuntimeException("없는 아이디"));

        Post post = postRepository.findById(updatePostDto.getPostId()).orElseThrow(() -> new RuntimeException("없는 포스트"));

        if(!user.equals(post.getUser())){
            throw new RuntimeException("포스트잇 주인이 아닙니다");
        }

        post.setContent(updatePostDto.getContent());

        return new PostResponse(post);

    }

    public List<PostResponse> getMain(String loginId){

        User user = userRepository.findByLoginId(loginId).orElseThrow(() -> new RuntimeException("없는 아이디"));

        if (user.getStatus() == "1"){
            List<Post> posts = postRepository.findAllByTeacherLoginId(user.getLoginId());
            return posts.stream().map(p -> new PostResponse(p)).collect(Collectors.toList());


        }else {
            List<Post> post = postRepository.findAllByUser(user);
            return post.stream().map(p -> new PostResponse(p)).collect(Collectors.toList());
        }

    }


}
