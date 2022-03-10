package hr.aom.aomoruzarstvoapp.controllers;


import hr.aom.aomoruzarstvoapp.model.Prijava;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        if(request.getSession().getAttribute("username") != null)
            return "redirect:/oruzar/zaduzenja";

        model.addAttribute("prijava", new Prijava());
        return "index";
    }

    @GetMapping("/logout")
    public String odjava(HttpServletRequest request) {
        request.getSession().removeAttribute("username");
        return "redirect:/";
    }
}
