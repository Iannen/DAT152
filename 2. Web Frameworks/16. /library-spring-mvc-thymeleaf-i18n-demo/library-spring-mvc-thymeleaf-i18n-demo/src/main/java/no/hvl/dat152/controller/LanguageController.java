/**
 * 
 */
package no.hvl.dat152.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author tdoy
 */

@Controller
public class LanguageController {

	@GetMapping("/global")
	public String home() {
		
		return "index";
	}
}
