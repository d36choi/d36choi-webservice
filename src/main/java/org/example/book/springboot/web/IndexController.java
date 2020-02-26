package org.example.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.example.book.springboot.config.auth.LoginUser;
import org.example.book.springboot.config.auth.dto.SessionUser;
import org.example.book.springboot.domain.user.User;
import org.example.book.springboot.service.posts.PostsService;
import org.example.book.springboot.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    // page 190

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null) {
            model.addAttribute("userName",user.getName());
        }
        return "index";
    // mustache 스타터 덕분에 앞 경로와 확장자는 알아서 지정됨.
    }

    /**
     * @return /posts/save 호출 시 posts-save.mustache 를 호출하는 메소드임!
     */
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model)
    {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
