package com.svgagan.justiceleague.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JusticeLeagueControllerTests {


    private JusticeLeagueController justiceLeagueController;

    @BeforeEach
    void setup(){
        justiceLeagueController = new JusticeLeagueController();
    }

    @Test
    public void fetchJusticeLeagueHeroesTest(){
        List<String> justiceLeagueHeroes = justiceLeagueController.fetchJusticeLeagueHeroes();
        justiceLeagueHeroes.stream().forEach(System.out::println);
        Assertions.assertEquals(3, justiceLeagueHeroes.size());
    }
}
