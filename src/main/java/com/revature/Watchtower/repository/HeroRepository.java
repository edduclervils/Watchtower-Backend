package com.revature.Watchtower.repository;

import com.revature.Watchtower.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {

    @Query(value = "SELECT * FROM Heroes WHERE species=:theSpecies", nativeQuery = true)
    public List<Hero> findSpecies(@Param("theSpecies") String theSpecies);

    @Query(value = "SELECT * FROM Heroes WHERE species=:theSpecies and has_power=:gotPower", nativeQuery = true)
    public List<Hero> findPowerSpecies(@Param("theSpecies") String theSpecies, @Param("gotPower") boolean gotPower);

    List<Hero> findByAlias(String alias);
    List<Hero> findByHasPowerTrue();
    List<Hero> findByHasPowerFalse();

    public List<Hero> findAllByOrderByIdAsc();
}
