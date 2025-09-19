package no.hvl.dat152.js.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/spa")
public class SPA {

    @GetMapping(path = "/spa/*")
    public String spademo() {
        return "spa";
    }

}
