/**
 * 
 */
package no.hvl.dat152.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import no.hvl.dat152.service.AuthorService;
import no.hvl.dat152.model.Author;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/addauthor")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService=authorService;
    }

    @GetMapping()
    public String returnView() {
        return "addauthor";
    }
    
	@PostMapping()
	public String saveAuthor(@ModelAttribute Author author) {
        this.authorService.saveAuthor(author);
        return "redirect:/";
	}
	
}
