package org.football.player.football.service;

import org.football.player.football.repository.MatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchesService {

    @Autowired
    public MatchesRepository matchesRepository;
}
