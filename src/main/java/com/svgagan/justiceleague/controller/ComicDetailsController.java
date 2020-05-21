package com.svgagan.justiceleague.controller;

import com.svgagan.justiceleague.model.ComicDetails;
import com.svgagan.justiceleague.service.ComicDetailsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comicDetails")
@Log4j2
public class ComicDetailsController {

    private ComicDetailsService comicDetailsService;

    @Autowired
    public ComicDetailsController(ComicDetailsService comicDetailsService){
        this.comicDetailsService = comicDetailsService;
    }

    @GetMapping
    public ResponseEntity<List<ComicDetails>> fetchAllComicDetails() throws Exception {
        log.info("Returning all Comics");
        List<ComicDetails> retrievedComics = this.comicDetailsService.findAllComics();
        return new ResponseEntity<>(retrievedComics, HttpStatus.OK);
    }

    @GetMapping(path = "{comicId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ComicDetails> fetchComic(@PathVariable String comicId) throws Exception {
        log.info("Returning a Comic");
        ComicDetails retrievedComic = this.comicDetailsService.findByComicId(comicId);
        return new ResponseEntity<>(retrievedComic, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ComicDetails> saveComic(@RequestBody ComicDetails comicDetails) throws Exception {
        log.info("Creating a Comic");
        ComicDetails retrievedComic = this.comicDetailsService.createComic(comicDetails);
        return new ResponseEntity<>(retrievedComic, HttpStatus.CREATED);
    }

    @PutMapping(path = "{comicId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ComicDetails> updateJusticeLeagueHero(@PathVariable String comicId, @RequestBody ComicDetails comicDetails) throws Exception {
        log.info("Updating a Comic");
        ComicDetails retrievedComic = this.comicDetailsService.updateComic(comicId, comicDetails);
        return new ResponseEntity<>(retrievedComic, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "{comicId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteComic(@PathVariable String comicId) throws Exception {
        log.info("Deleting a Comic");
        this.comicDetailsService.deleteComic(comicId);
    }
}
