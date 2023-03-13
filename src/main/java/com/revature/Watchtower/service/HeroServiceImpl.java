package com.revature.Watchtower.service;

import com.revature.Watchtower.entity.Hero;
import com.revature.Watchtower.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class HeroServiceImpl implements HeroService{

    @Autowired
    HeroRepository heroRepository;
    @Override
    public Hero insert(Hero hero) {
        return heroRepository.save(hero);
    }

    @Override
    public Hero getById(Long id) {
        return heroRepository.findById(id).get();
    }

    @Override
    public List<Hero> getAll() { return heroRepository.findAllByOrderByIdAsc(); }

    @Override
    public Hero update(Hero hero) {
        return heroRepository.save(hero);
    }

    @Override
    public boolean delete(Long id) {
        boolean found = heroRepository.existsById(id);
        if (found) heroRepository.deleteById(id);
        return found;
    }

    @Override
    public List<Hero> getAll(String flag) {
        if (flag == null){
            return heroRepository.findAllByOrderByIdAsc();
        }
        else {
            return heroRepository.findSpecies(flag);
        }
//        switch (flag){
//            case "human":
//                return heroRepository.findHumans();
//            default:
//                return heroRepository.findAll();
//        }
    }

    @Override
    public List<Hero> findByAlias(String alias) {
        return heroRepository.findByAlias(alias);
    }

    @Override
    public List<Hero> findByPower(boolean gotPower) {
        if (gotPower) return heroRepository.findByHasPowerTrue();
        else return heroRepository.findByHasPowerFalse();
    }

    @Override
    public List<Hero> findBothPowerAndSpecies(String flag, boolean gotPower) {
        if (flag == null){
            if (gotPower) return heroRepository.findByHasPowerTrue();
            else return heroRepository.findByHasPowerFalse();
        }
        else {
            return heroRepository.findPowerSpecies(flag,gotPower);
        }
    }
}
