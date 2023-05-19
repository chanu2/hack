package gdschack.server.controller;

import gdschack.server.dto.request.PostCreateDto;
import gdschack.server.dto.response.PostResponse;
import gdschack.server.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public PostResponse CreatePost(@RequestBody PostCreateDto postCreateDto){

        return postService.createPost(postCreateDto);
    }

    @GetMapping("/detail/{id}")
    public PostResponse detailPost(@PathVariable Long id){
        return postService.detailPost(id);
    }

    @GetMapping("/main/{logInId}")
    public List<PostResponse> getMain(@PathVariable String logInId){
        return postService.getMain(logInId);
    }





}
