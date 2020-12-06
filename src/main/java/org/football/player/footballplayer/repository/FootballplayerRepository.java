package org.football.player.footballplayer.repository;

import org.football.player.footballplayer.model.Playerbasicinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballplayerRepository extends JpaRepository<Playerbasicinfo,Long> {
    Playerbasicinfo findByPlayername(String playerName);

    Playerbasicinfo findByPlayernameAndNationality(String playername, String nationality);
}
