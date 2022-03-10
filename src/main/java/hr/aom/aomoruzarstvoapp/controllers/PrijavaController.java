package hr.aom.aomoruzarstvoapp.controllers;

import hr.aom.aomoruzarstvoapp.model.Prijava;
import hr.aom.aomoruzarstvoapp.model.Racun;
import hr.aom.aomoruzarstvoapp.service.RacunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


@Controller
public class PrijavaController {

    @Autowired
    private RacunService racunService;

    @PostMapping("/prijava")
    public String login(@ModelAttribute Prijava prijava, HttpServletRequest request, Model model) {
        Optional<Racun> racun2 = racunService.findByUsernameAndPassword(new Racun(prijava));

        if(racun2.isPresent()) {
            request.getSession().setAttribute("username", racun2.get().getUsername());
            return "redirect:/oruzar/zaduzenja";
        }

        model.addAttribute("loginError", true);
        return "index";
    }
}
