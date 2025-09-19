package no.hvl.dat152.js.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import no.hvl.dat152.js.model.Subscription;

@Controller
@RequestMapping(path = "/spa")
public class SubscribeCourse {

    @PostMapping(path = "/subscribe")
    public RedirectView addSubscription(@ModelAttribute Subscription subscription, RedirectAttributes ra) {
        RedirectView rv = new RedirectView("subscribe", true);
        ra.addFlashAttribute("subscription", subscription);
        return rv;
    }

    @GetMapping(path = "/subscribe")
    public String addSubscriptionGet(@ModelAttribute Subscription subscription) {

        return "confirmation";
    }
}
