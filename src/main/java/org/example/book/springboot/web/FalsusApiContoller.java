package org.example.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.example.book.springboot.service.falsuses.FalsusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Controller
public class FalsusApiContoller {

    private final FalsusService falsusService;

    @GetMapping("/falsus/list")
    public String showList(Model model)
    {
        model.addAttribute("falsuses", falsusService.findAllDesc());


        return "falsus-list";
    }

}
