package org.football.player.football.controller;

import lombok.NoArgsConstructor;
import org.football.player.football.service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
public class MatchesController {

    @Autowired
    MatchesService matchesService;
}
