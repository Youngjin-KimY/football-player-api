package org.football.player.football.service;

import lombok.AllArgsConstructor;
import org.football.player.football.dto.PutTeamReq;
import org.football.player.football.exception.BussinessException;
import org.football.player.football.dto.PostTeamReq;
import org.football.player.football.exception.InValidParameterException;
import org.football.player.football.exception.NoResourceException;
import org.football.player.football.model.Team;
import org.football.player.football.repository.TeamsHistoryRepository;
import org.football.player.football.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class TeamsService {

    @Autowired
    TeamsRepository teamsRepository;

    @Autowired
    TeamsHistoryRepository teamsHistoryRepository;

    public ArrayList<Team> GetTeams(){
        var list = teamsRepository.findAll();
        ArrayList<Team> arrList = new ArrayList<Team>(list);
        return arrList;
    }

    @Transactional
    public Team AddTeam(PostTeamReq req) throws BussinessException{
        var saveEntity = req.ToEntity();
        var checker = teamsRepository.findAll().stream()
                .filter(team->team.teamName.equals(req.teamName) && team.division==req.division).count();

        if(checker != 0)
            throw new BussinessException("already existed team name");

        var ret = teamsRepository.save(saveEntity);
        var saveHistEntity = req.ToHistEntity(ret.teamId);
        var retHist = teamsHistoryRepository.save(saveHistEntity);

        return ret;
    }

    @Transactional
    public Team UpdateTeam(PutTeamReq req) throws NoResourceException, InValidParameterException {
        var team = teamsRepository.findById(req.teamId);
        if(!team.isPresent())
            throw new NoResourceException("no team data");
        if(!team.get().getTeamName().equals(req.teamName))
            throw new InValidParameterException("teamname is wrong, check teamname you input");

        req.createdAt = team.get().createdAt;
        req.createdBy = team.get().createdBy;

        var ret = teamsRepository.save(req.ToEntity());
        teamsHistoryRepository.save(req.ToHistEntity());

        return ret;
    }

    public Team GetTeam(int teamId) throws NoResourceException {
        var team = teamsRepository.findById(teamId);
        if(!team.isPresent())
            throw new NoResourceException("no team data, check teamId");

        return team.get();
    }
}
