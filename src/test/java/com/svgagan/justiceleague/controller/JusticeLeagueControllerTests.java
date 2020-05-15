package com.svgagan.justiceleague.controller;

import com.svgagan.justiceleague.model.SuperHeroes;
import com.svgagan.justiceleague.service.JusticeLeagueService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@ExtendWith(MockitoExtension.class)
public class JusticeLeagueControllerTests {


    private JusticeLeagueController justiceLeagueController;

    @Mock
    private JusticeLeagueService justiceLeagueService;

    @BeforeEach
    void setup(){
        justiceLeagueController = new JusticeLeagueController(justiceLeagueService);
    }

    @Test
    public void fetchJusticeLeagueHeroesTest() throws Exception {

        SuperHeroes superHeroes = new SuperHeroes("dark-knight", "BATMAN", true, new Date(), new Date(), "DC");
        Mockito.when(justiceLeagueService.findAllSuperHero()).thenReturn(Arrays.asList(superHeroes, superHeroes));

        ResponseEntity<List<SuperHeroes>> justiceLeagueHeroes = justiceLeagueController.fetchAllJusticeLeagueHeroes();
        Assertions.assertEquals(2, Objects.requireNonNull(justiceLeagueHeroes.getBody()).size());
    }
}
