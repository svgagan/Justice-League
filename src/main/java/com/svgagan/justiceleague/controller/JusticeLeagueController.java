package com.svgagan.justiceleague.controller;

import com.svgagan.justiceleague.model.SuperHeroes;
import com.svgagan.justiceleague.service.JusticeLeagueService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/justiceLeague")
@Log4j2
public class JusticeLeagueController {

    private JusticeLeagueService justiceLeagueService;

    @Autowired
    public JusticeLeagueController(JusticeLeagueService justiceLeagueService){
        this.justiceLeagueService = justiceLeagueService;
    }

    @GetMapping
    public ResponseEntity<List<SuperHeroes>> fetchAllJusticeLeagueHeroes() throws Exception {
        log.info("Returning all Justice League Heroes");
        List<SuperHeroes> retrievedSuperHeroes = this.justiceLeagueService.findAllSuperHero();
        return new ResponseEntity<>(retrievedSuperHeroes, HttpStatus.OK);
    }

    @GetMapping(path = "{superHeroId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuperHeroes> fetchJusticeLeagueHero(@PathVariable String superHeroId) throws Exception {
        log.info("Returning a Justice League Hero");
        SuperHeroes retrievedSuperHero = this.justiceLeagueService.findSuperHero(superHeroId);
        return new ResponseEntity<>(retrievedSuperHero, HttpStatus.OK);
    }

    @PostMapping (produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuperHeroes> saveJusticeLeagueHero(@RequestBody SuperHeroes superHeroes) throws Exception {
        log.info("Creating a Justice League Hero");
        SuperHeroes retrievedSuperHero = this.justiceLeagueService.createSuperHero(superHeroes);
        return new ResponseEntity<>(retrievedSuperHero, HttpStatus.CREATED);
    }

    @PutMapping(path = "{superHeroId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuperHeroes> updateJusticeLeagueHero(@PathVariable String superHeroId, @RequestBody SuperHeroes superHeroes) throws Exception {
        log.info("Updating a Justice League Hero");
        SuperHeroes retrievedSuperHero = this.justiceLeagueService.updateSuperHero(superHeroId, superHeroes);
        return new ResponseEntity<>(retrievedSuperHero, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "{superHeroId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteJusticeLeagueHero(@PathVariable String superHeroId) throws Exception {
        log.info("Deleting a Justice League Hero");
        this.justiceLeagueService.deleteSuperHero(superHeroId);
    }
}
