package gdschack.server.controller;

import gdschack.server.dto.request.DetailPostDto;
import gdschack.server.dto.request.PostCreateDto;
import gdschack.server.dto.request.UpdatePostDto;
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

    @GetMapping("/detail")
    public PostResponse detailPost(@RequestBody DetailPostDto detailPostDto){
        return postService.detailPost(detailPostDto);
    }

    @GetMapping("/main/{logInId}")
    public List<PostResponse> getMain(@PathVariable String logInId){
        return postService.getMain(logInId);
    }

    @PatchMapping("/update")
    public PostResponse updatePost(@RequestBody UpdatePostDto updatePostDto){
        return postService.updatePost(updatePostDto);
    }





}
