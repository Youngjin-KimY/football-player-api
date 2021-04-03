package org.football.player.football.controller;

import org.football.player.football.exception.BussinessException;
import org.football.player.football.dto.PostTeamReq;
import org.football.player.football.model.Team;
import org.football.player.football.repository.TeamsHistoryRepository;
import org.football.player.football.repository.TeamsRepository;
import org.football.player.football.service.TeamsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
public class TeamsControllerTest {

    @MockBean
    private TeamsService mockteamsService;

    @Autowired
    private TeamsRepository teamsRepository;

    @Test
    public void MockAddTest() throws BussinessException {
        PostTeamReq req = new PostTeamReq();
        req.setTeamName("WestHam United");
        req.setDivision(1);

        given(mockteamsService.AddTeam(req)).willReturn(req.ToEntity());

        var ret =mockteamsService.AddTeam(req);
        Assertions.assertEquals(ret.division,req.getDivision());
        Assertions.assertEquals(ret.teamName,req.getTeamName());
    }

}