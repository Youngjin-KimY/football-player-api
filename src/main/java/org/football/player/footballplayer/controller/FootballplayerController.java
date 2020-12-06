package org.football.player.footballplayer.controller;

import org.football.player.footballplayer.dto.PostPlayerbasicinfoRequestDto;
import org.football.player.footballplayer.model.Playerbasicinfo;
import org.football.player.footballplayer.service.FootballplayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class FootballplayerController {

    @Autowired
    FootballplayerService footBallPlayerService;

    @RequestMapping(value="/api/v1/football-player/basicinfo/{nationality}/{name}",method = RequestMethod.GET)
    public Playerbasicinfo GetFootBallPlayerInfo(@PathVariable("name") String name, @PathVariable("nationality") String nation)
    {
        return footBallPlayerService.GetFootBallPlayerInfo(name,nation);
    }

    @RequestMapping(value="",method = RequestMethod.POST)
    public Long PostFootBallPlayerInfo(@RequestBody PostPlayerbasicinfoRequestDto postPlayerbasicinfoRequestDto)
    {
        return footBallPlayerService.PostFootBallPlayerInfo(postPlayerbasicinfoRequestDto);
    }
}
