package org.football.player.football.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "matches")
public class Match{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long seq;
    @Column
    public String homeTeam;
    @Column
    public String awayTeam;
    @Column
    public String stadium;
    @Column
    public byte homeTeamScore;
    @Column
    public byte awayTeamScore;
    @Column
    public String result;
    @Column
    public char isUse;
    @Column
    public LocalDate matchDate;
    @Column
    public LocalDate createdAt;
    @Column
    public String createdBy;
    @Column
    public LocalDate modifiedAt;
    @Column
    public String modifiedBy;

    @Builder
    public Match(String homeTeam, String awayTeam, String stadium, byte homeTeamScore, byte awayTeamScore, String result, char isUse, LocalDate matchDate, LocalDate createdAt, String createdBy, LocalDate modifiedAt, String modifiedBy) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.stadium = stadium;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.result = result;
        this.isUse = isUse;
        this.matchDate = matchDate;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
    }
}
