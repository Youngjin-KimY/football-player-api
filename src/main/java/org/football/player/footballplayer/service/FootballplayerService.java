package org.football.player.footballplayer.service;

import lombok.RequiredArgsConstructor;
import org.football.player.footballplayer.dto.PostPlayerbasicinfoRequestDto;
import org.football.player.footballplayer.model.Playerbasicinfo;
import org.football.player.footballplayer.repository.FootballplayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class FootballplayerService {

    FootballplayerRepository footballplayerRepository;

    public Playerbasicinfo GetFootBallPlayerInfo(String name, String nation) {
        return footballplayerRepository.findByPlayernameAndNationality(name,nation);
    }

    @Transactional
    public Long PostFootBallPlayerInfo(PostPlayerbasicinfoRequestDto postPlayerbasicinfoRequestDto) {
        return footballplayerRepository.save(postPlayerbasicinfoRequestDto.toEntity()).getId();
    }
}
