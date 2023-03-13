package com.revature.Watchtower.service;

import com.revature.Watchtower.entity.Hero;

import java.util.List;

public interface HeroService {
    Hero insert(Hero hero);
    Hero getById(Long id);
    List<Hero> getAll();
    Hero update(Hero hero);
    boolean delete(Long id);
    List<Hero> getAll(String flag);
    List<Hero> findByAlias(String alias);
    List<Hero> findByPower(boolean gotPower);
    List<Hero> findBothPowerAndSpecies(String flag, boolean gotPower);
}
