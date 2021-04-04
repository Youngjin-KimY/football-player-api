package org.football.player.football.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.football.player.football.model.Match;
import org.football.player.football.model.MatchCode;

import javax.persistence.Column;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class PostMatchReq {
    public String homeTeam;
    public String awayTeam;
    public String stadium;
    public byte homeTeamScore;
    public byte awayTeamScore;
    public MatchCode result;
    public char isUse;
    public LocalDate matchDate;
    public String createdBy;

    public Match ToMatchEntity(){
        return Match.builder()
                .homeTeam(this.homeTeam)
                .homeTeamScore(this.homeTeamScore)
                .stadium(this.stadium)
                .awayTeam(this.awayTeam)
                .awayTeamScore(this.awayTeamScore)
                .result(this.result.toString())
                .isUse(this.isUse)
                .matchDate(this.matchDate)
                .createdBy(this.createdBy)
                .build();
    }
}
