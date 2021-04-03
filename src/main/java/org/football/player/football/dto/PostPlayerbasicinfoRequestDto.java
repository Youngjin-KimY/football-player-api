package org.football.player.football.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.football.player.football.model.Playerbasicinfo;

import java.util.Date;

@Getter
@NoArgsConstructor
public class PostPlayerbasicinfoRequestDto {
    String nationality;
    String playername;
    int height;
    int weight;
    Date birth;
    char foot;
    String position;

    @Builder
    public PostPlayerbasicinfoRequestDto(String nationality, String playername, int height, int weight, Date birth, char foot, String position) {
        this.nationality = nationality;
        this.playername = playername;
        this.height = height;
        this.weight = weight;
        this.birth = birth;
        this.foot = foot;
        this.position = position;
    }

    public Playerbasicinfo toEntity()
    {
        return Playerbasicinfo.builder()
                .nationality(this.nationality)
                .playername(this.playername)
                .height(this.height)
                .weight(this.weight)
                .birth(this.birth)
                .foot(this.foot)
                .position(this.position)
                .build();
    }
}
