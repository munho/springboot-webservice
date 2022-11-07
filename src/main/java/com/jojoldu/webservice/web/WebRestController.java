package com.jojoldu.webservice.web;

import com.jojoldu.webservice.domain.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jojoldu@gmail.com on 2017. 12. 24.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostService postService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long savePost(@RequestBody PostsSaveRequestDto dto) {
        return postService.save(dto);
    }
}
