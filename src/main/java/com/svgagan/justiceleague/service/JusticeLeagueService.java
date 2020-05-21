package com.svgagan.justiceleague.service;

import com.svgagan.justiceleague.model.ComicDetails;
import com.svgagan.justiceleague.model.SuperHeroes;
import com.svgagan.justiceleague.repository.JusticeLeagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JusticeLeagueService {

    private JusticeLeagueRepository justiceLeagueRepository;
    private ComicDetailsService comicDetailsService;

    public JusticeLeagueService(JusticeLeagueRepository justiceLeagueRepository, ComicDetailsService comicDetailsService){
        this.justiceLeagueRepository = justiceLeagueRepository;
        this.comicDetailsService = comicDetailsService;
    }

    public List<SuperHeroes> findAllSuperHero() throws Exception {
        return this.justiceLeagueRepository.findAll();
    }

    public SuperHeroes findSuperHero(String superHeroId) throws Exception {
        Optional<SuperHeroes> existing = this.justiceLeagueRepository.findById(superHeroId);
        if(!existing.isPresent()){
            throw new Exception("SuperHero Not Exists");
        }
        return existing.get();
    }

    public SuperHeroes createSuperHero(SuperHeroes superHeroes) throws Exception {
        Optional<SuperHeroes> existing = this.justiceLeagueRepository.findById(superHeroes.getId());
        if(existing.isPresent()){
            throw new Exception("SuperHero Exists");
        }

        ComicDetails existingComic = this.comicDetailsService.findByComicId(superHeroes.getComicDetailsId());
        if(existingComic.getStatus().equals(Boolean.FALSE)) {
            throw new Exception("Comic is Disabled, SuperHero creation failed");
        }

        return this.justiceLeagueRepository.save(superHeroes);
    }

    public SuperHeroes updateSuperHero(String superHeroId, SuperHeroes superHeroes) throws Exception {
        Optional<SuperHeroes> existing = this.justiceLeagueRepository.findById(superHeroId);
        if(!existing.isPresent()){
            throw new Exception("SuperHero Not Found");
        }
        superHeroes.setId(superHeroId);
        return this.justiceLeagueRepository.save(superHeroes);
    }

    public void deleteSuperHero(String superHeroId) throws Exception {
        Optional<SuperHeroes> existing = this.justiceLeagueRepository.findById(superHeroId);
        if(!existing.isPresent()){
            throw new Exception("SuperHero Not Found");
        }
        this.justiceLeagueRepository.deleteById(superHeroId);
    }


}
