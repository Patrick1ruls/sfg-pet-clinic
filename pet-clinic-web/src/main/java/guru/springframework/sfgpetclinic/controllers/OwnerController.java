package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners") // Removes the need for specifying /owners in the request mapping below
@Controller // The traffic controller for the owners web page
public class OwnerController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners() {

        return "owners/index"; // hits the thymeleaf ownerss.index.html page
    }
}
