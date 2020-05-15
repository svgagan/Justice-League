package com.svgagan.justiceleague.service;

import com.svgagan.justiceleague.model.SuperHeroes;
import com.svgagan.justiceleague.repository.JusticeLeagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JusticeLeagueService {

    private JusticeLeagueRepository justiceLeagueRepository;

    public JusticeLeagueService(JusticeLeagueRepository justiceLeagueRepository){
        this.justiceLeagueRepository = justiceLeagueRepository;
    }

    public List<SuperHeroes> findAllSuperHero() throws Exception {
        return this.justiceLeagueRepository.findAll();
    }

    public SuperHeroes findSuperHero(String name) throws Exception {
        Optional<SuperHeroes> existing = this.justiceLeagueRepository.findBySuperHeroName(name);
        if(!existing.isPresent()){
            throw new Exception("Bad Request");
        }
        return existing.get();
    }

    public SuperHeroes createSuperHero(SuperHeroes superHeroes) throws Exception {
        Optional<SuperHeroes> existing = this.justiceLeagueRepository.findBySuperHeroName(superHeroes.getSuperHeroName());
        if(existing.isPresent()){
            throw new Exception("Bad Request");
        }
        return this.justiceLeagueRepository.save(superHeroes);
    }

    public SuperHeroes updateSuperHero(String superHeroNme, SuperHeroes superHeroes) throws Exception {
        Optional<SuperHeroes> existing = this.justiceLeagueRepository.findBySuperHeroName(superHeroNme);
        if(!existing.isPresent()){
            throw new Exception("SuperHero Not Found");
        }
        superHeroes.setId(superHeroNme);
        return this.justiceLeagueRepository.save(superHeroes);
    }

    public void deleteSuperHero(String superHeroNme) throws Exception {
        Optional<SuperHeroes> existing = this.justiceLeagueRepository.findBySuperHeroName(superHeroNme);
        if(!existing.isPresent()){
            throw new Exception("SuperHero Not Found");
        }
        this.justiceLeagueRepository.deleteById(superHeroNme);
    }


}
