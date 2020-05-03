package com.svgagan.justiceleague.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/justiceLeague")
@Log4j2
public class JusticeLeagueController {

    @GetMapping
    public List<String> fetchJusticeLeagueHeroes(){
        log.info("Returning Justice League Heroes");
        return Arrays.asList("Batman", "Superman", "Wonder-Woman");
    }
}
