package org.example.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.example.book.springboot.service.posts.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
//        mustache 스타터 덕분에 앞 경로와 확장자는 알아서 지정됨.
    }

    /**
     * @return /posts/save 호출 시 posts-save.mustache 를 호출하는 메소드임!
     */
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
