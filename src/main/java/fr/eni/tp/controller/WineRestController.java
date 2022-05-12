package fr.eni.tp.controller;

import fr.eni.tp.bo.Wine;
import fr.eni.tp.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wines")
public class WineRestController {
    private WineService wineService;

    @Autowired
    public WineRestController(WineService wineService) {
        this.wineService = wineService;
    }



    @GetMapping
    public List<Wine> findAll() {
        return wineService.findAll();
    }

    @GetMapping("/{id}")
    public Wine findById(@PathVariable long id) {
        Wine wine = wineService.findById(id);
        if (wine == null) {
            throw new RuntimeException("wine not found, id : " + id);
        }
        return wine;
    }

    @PostMapping
    public Wine addWine(@RequestBody Wine wine) {
        System.out.println("addWine");
        System.out.println(wine);
        // Also just in case they pass an id in JSON...
        // Set id to 0 this is to force a save of new itemm..
        // instead of update
        wine.setId(0);
        try {
            wineService.save(wine);
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return wine;
    }

    @PutMapping
    public Wine updateWine(@RequestBody Wine wine){
        System.out.println("update wine");
        System.out.println(wine);
        try {
            wineService.save(wine);
        }catch (RuntimeException e){
            e.printStackTrace();
        }

        return wine;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable long id){
        try {
            wineService.delete(id);
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return "deleted article id: " + id;
    }
}
