package fr.eni.tp.controller;

import fr.eni.tp.bo.Wine;
import fr.eni.tp.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WineController {

    private WineService wineService;

    @Autowired
    public WineController(WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping("/bouteilles.html")
    public String getWines(Model model){
        List<Wine> wines = wineService.findAll();
        model.addAttribute("wines", wines);
        return "bouteilles";
    }
}
