package com.svgagan.justiceleague.repository;

import com.svgagan.justiceleague.model.SuperHeroes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JusticeLeagueRepository extends JpaRepository<SuperHeroes, String> {

    public Optional<SuperHeroes> findBySuperHeroName(String superHeroName);

    public Optional<SuperHeroes> findById(String superHeroId);

}
