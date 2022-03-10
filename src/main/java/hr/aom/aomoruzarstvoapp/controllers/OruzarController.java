package hr.aom.aomoruzarstvoapp.controllers;

import hr.aom.aomoruzarstvoapp.model.*;
import hr.aom.aomoruzarstvoapp.service.OpremaService;
import hr.aom.aomoruzarstvoapp.service.OsobaService;
import hr.aom.aomoruzarstvoapp.service.PosudbaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OruzarController {

    @Autowired
    OpremaService opremaService;
    @Autowired
    PosudbaService posudbaService;
    @Autowired
    OsobaService osobaService;

    @GetMapping("/oruzar/zaduzenja")
    public String dodajUkloniZaduzenje(Model model, HttpServletRequest request) {
        if(request.getSession().getAttribute("username") == null)
            return "redirect:/";

        model.addAttribute("opremaList", opremaService.findAll());
        model.addAttribute("zaduzenje", new Zaduzenje());
        model.addAttribute("otkaz", new Otkaz());
        model.addAttribute("osobe", osobaService.findAll());

        List<PrikazPosudbe> prikazPosudbeList = PrikazPosudbe.dohvatiPrikazPosudbi(
                posudbaService.findAll(),
                osobaService.findAll(),
                opremaService.findAll()
        );
        model.addAttribute("prikazPosudbi", prikazPosudbeList);
        return "oruzarHome";
    }

    @PostMapping("/oruzar/zaduzi")
    public String dodajZaduzenje(@ModelAttribute Zaduzenje zaduzenje, Model model) {
        try {
            opremaService.spremiZaduzenja(zaduzenje);
        } catch (ParseException e) {
            System.err.println("Krivi format datuma");
        }
        return "redirect:/oruzar/zaduzenja";
    }

    @PostMapping("/oruzar/otkazi")
    public String otkaziZaduzenje(@ModelAttribute Otkaz otkaz, Model model) {
        try {
            posudbaService.deletePoUsernameIDatum(new Posudba(
                            otkaz.getUsername(),
                            new SimpleDateFormat("yyyy-MM-dd").parse(otkaz.getDatumpovrata())
                    ));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "redirect:/oruzar/zaduzenja";
    }

    @GetMapping("/oruzar/popis")
    public String popisOpreme(Model model, HttpServletRequest request) {
        if(request.getSession().getAttribute("username") == null)
            return "redirect:/";
        model.addAttribute("opremaList", opremaService.findAll());
        return "popisOpreme";
    }

    @PostMapping("/oruzar/ucitajIzExcela")
    public String obrisiIUcitajExcel(@RequestParam("excelDatoteka") MultipartFile file, Model model) {
        try {
            opremaService.spremiOpremuIzExcela(file.getInputStream());
        } catch (IOException e) {
            //todo
        }
        return "redirect:/oruzar/popis";
    }
}
