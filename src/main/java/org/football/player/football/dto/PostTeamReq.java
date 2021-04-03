package org.football.player.football.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.football.player.football.model.Team;
import org.football.player.football.model.TeamsHistory;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PostTeamReq {
    public String teamName;
    public int division;
    public char isUse;
    public String createdBy;

    public Team ToEntity(){
        return Team.builder()
                .teamName(this.teamName)
                .division(this.division)
                .isUse(this.isUse)
                .createdBy(this.createdBy)
                .createdAt(LocalDate.now())
                .build();
    }

    public TeamsHistory ToHistEntity(int teamId)
    {
        return TeamsHistory.builder()
                .teamName(this.teamName)
                .division(this.division)
                .isUse(this.isUse)
                .teamId(teamId)
                .createdBy(this.createdBy)
                .createdAt(LocalDate.now())
                .build();
    }
}
