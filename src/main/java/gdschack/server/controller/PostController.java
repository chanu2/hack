package gdschack.server.controller;

import gdschack.server.dto.request.PostCreateDto;
import gdschack.server.dto.response.PostResponse;
import gdschack.server.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public PostResponse postResponse(@RequestBody PostCreateDto postCreateDto){

        return postService.createPost(postCreateDto);
    }


}
