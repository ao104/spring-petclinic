package org.springframework.samples.petclinic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final OwnerRepository ownerRepository;

    @Autowired
    public HomeController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @GetMapping("/home")
    public String home(Model model) {
        long ownerCount = ownerRepository.countOwners(); // Repositoryのメソッドを使用
        model.addAttribute("ownerCount", ownerCount);
        return "home";
    }
    //test
}
