package org.football.player.footballplayer.model;


import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Playerbasicinfo {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotNull
    String nationality;
    @NotNull
    String playername;
    @Nullable
    int height;
    @Nullable
    int weight;
    @Nullable
    Date birth;
    @Nullable
    char foot;
    @Nullable
    String position;

    @Builder
    public Playerbasicinfo(String nationality, String playername, int height, int weight, Date birth, char foot, String position) {
        this.nationality = nationality;
        this.playername = playername;
        this.height = height;
        this.weight = weight;
        this.birth = birth;
        this.foot = foot;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Id: "+id+" PlayerName: "+playername+" Nationality: "+nationality;
    }
}
