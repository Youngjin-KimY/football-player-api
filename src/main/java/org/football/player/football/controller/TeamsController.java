package org.football.player.football.controller;

import lombok.NoArgsConstructor;

import org.football.player.football.dto.PutTeamReq;
import org.football.player.football.exception.BussinessException;
import org.football.player.football.dto.PostTeamReq;
import org.football.player.football.exception.InValidParameterException;
import org.football.player.football.exception.NoResourceException;
import org.football.player.football.model.Team;
import org.football.player.football.service.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@NoArgsConstructor
public class TeamsController {

    @Autowired
    TeamsService teamsService;
    @RequestMapping(value = "/api/v1/teams/{teamId}",method = RequestMethod.GET)
    public Team GetTeam(@PathVariable int teamId) throws NoResourceException {
        Team team = teamsService.GetTeam(teamId);
        return team;
    }

    @RequestMapping(value = "/api/v1/teams",method = RequestMethod.GET)
    public ArrayList<Team> GetTeamList(){
        ArrayList<Team> teams = teamsService.GetTeams();
        return teams;
    }

    @RequestMapping(value = "/api/v1/teams",method = RequestMethod.POST)
    public Team AddTeam(@RequestBody PostTeamReq req) throws BussinessException{
        return teamsService.AddTeam(req);
    }

    @RequestMapping(value="/api/v1/teams",method = RequestMethod.PUT)
    public Team UpdateTeam(@RequestBody PutTeamReq req) throws NoResourceException, InValidParameterException {
        return teamsService.UpdateTeam(req);
    }
}
