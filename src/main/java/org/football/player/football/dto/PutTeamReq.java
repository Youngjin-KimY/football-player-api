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
public class PutTeamReq {
    public int teamId;
    public String teamName;
    public int division;
    public char isUse;
    public String createdBy;
    public LocalDate createdAt;
    public String modifiedBy;

    public Team ToEntity(){
        return Team.builder()
                .teamId(this.teamId)
                .teamName(this.teamName)
                .division(this.division)
                .isUse(this.isUse)
                .createdBy(this.createdBy)
                .createdAt(this.createdAt)
                .modifiedBy(this.modifiedBy)
                .modifiedAt(LocalDate.now())
                .build();
    }

    public TeamsHistory ToHistEntity()
    {
        return TeamsHistory.builder()
                .teamName(this.teamName)
                .division(this.division)
                .isUse(this.isUse)
                .teamId(this.teamId)
                .createdBy(this.createdBy)
                .createdAt(this.createdAt)
                .modifiedBy(this.modifiedBy)
                .modifiedAt(LocalDate.now())
                .build();
    }
}
