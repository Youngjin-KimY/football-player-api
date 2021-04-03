package org.football.player.football.model;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TeamsHistory{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long seq;
    @NotNull
    @Column(name = "team_id")
    public int teamId;
    @NotNull
    @Column(name = "team_name")
    public String teamName;
    @NotNull
    @Column(name = "division")
    public int division;

    @Column(name = "isUse")
    public char isUse;

    @Column(name = "created_by")
    public String createdBy;
    @Column(name = "created_At")
    public LocalDate createdAt;
    @Column(name = "modified_by")
    public String modifiedBy;
    @Column(name = "modified_At")
    public LocalDate modifiedAt;

    @Builder
    public TeamsHistory(int teamId,String teamName,int division,char isUse,String createdBy,LocalDate createdAt, String modifiedBy,
                        LocalDate modifiedAt){
        this.teamId = teamId;
        this.teamName = teamName;
        this.division = division;
        this.isUse = isUse;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
    }
}
