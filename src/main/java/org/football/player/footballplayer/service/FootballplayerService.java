package org.football.player.footballplayer.service;

import lombok.RequiredArgsConstructor;
import org.football.player.footballplayer.dto.PostPlayerbasicinfoRequestDto;
import org.football.player.footballplayer.model.Playerbasicinfo;
import org.football.player.footballplayer.repository.FootballplayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FootballplayerService {

    @Autowired
    FootballplayerRepository footballplayerRepository;

    public Playerbasicinfo GetFootBallPlayerInfo(String name, String nation) {
        var ret = footballplayerRepository.findByPlayernameAndNationality(name,nation);
        return ret;
    }

    @Transactional
    public Long PostFootBallPlayerInfo(PostPlayerbasicinfoRequestDto postPlayerbasicinfoRequestDto) {
        var param = postPlayerbasicinfoRequestDto.toEntity();
        var ret = footballplayerRepository.save(param).getId();
        return ret;
    }
}
