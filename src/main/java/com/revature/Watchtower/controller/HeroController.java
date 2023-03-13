package com.revature.Watchtower.controller;

import com.revature.Watchtower.entity.Hero;
import com.revature.Watchtower.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heroes")
@CrossOrigin
public class HeroController {

    @Autowired
    HeroService heroService;

    @PostMapping()
    public Hero insert(@RequestBody Hero hero){
        return heroService.insert(hero);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Hero> getAll(@RequestParam(required = false, value = "species") String flag, @RequestParam(required = false, value = "hasPower") String gotPower ){
        if (flag == null && gotPower == null) {
            return heroService.getAll();
        } else if (flag != null && gotPower == null) {
            return heroService.getAll(flag);
        } else if (flag == null && gotPower != null) {
            if (gotPower.toLowerCase().equals("true")) {
                return heroService.findByPower(true);
            } else if (gotPower.toLowerCase().equals("false")) {
                return heroService.findByPower(false);
            } else {
                return heroService.getAll();
            }
        } else {
            if (gotPower.toLowerCase().equals("true")) {
                return heroService.findBothPowerAndSpecies(flag,true);
            } else if (gotPower.toLowerCase().equals("false")) {
                return heroService.findBothPowerAndSpecies(flag,false);
            } else {
                return heroService.getAll(flag);
            }
        }
    }
    @GetMapping("/{heroIdentifier}")
    public Hero getByIdOrAlias(@PathVariable("heroIdentifier") String identifier){
        try{
            Long id = Long.parseLong(identifier);
            return heroService.getById(id);
        }
        catch (Exception e){
            return heroService.findByAlias(identifier).get(0);
        }
    }

    @PutMapping()
    public Hero update(@RequestBody Hero hero){
        return heroService.update(hero);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return heroService.delete(id);
    }
}
