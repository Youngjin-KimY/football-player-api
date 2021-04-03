package org.football.player.football.repository;

import org.football.player.football.model.Playerbasicinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballplayerRepository extends JpaRepository<Playerbasicinfo,Long> {
    Playerbasicinfo findByPlayername(String playerName);

    Playerbasicinfo findByPlayernameAndNationality(String playername, String nationality);
}
