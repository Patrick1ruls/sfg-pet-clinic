package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"}) // Go to the index page with any of these mappings
    public String index() {

        // Wires controller to index.html thymeleaf page
        return "index";
    }
}
