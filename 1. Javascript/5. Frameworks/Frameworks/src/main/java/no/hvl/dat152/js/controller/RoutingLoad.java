package no.hvl.dat152.js.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/spa")
public class RoutingLoad {

    @GetMapping(path = "/routingload/*")
    public String routingdemo(HttpServletRequest request,Model model) {
        Pattern p = Pattern.compile("^(.*/spa)/routingload.*");
        Matcher m = p.matcher(request.getRequestURL());
        String path = "";
        if (m.find()) {
            path = m.group(1);
        }
        model.addAttribute("path", path);
        
        return "routingload";
    }
}
