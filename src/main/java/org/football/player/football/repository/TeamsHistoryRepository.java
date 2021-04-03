package org.football.player.football.repository;

import org.football.player.football.model.TeamsHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsHistoryRepository extends JpaRepository<TeamsHistory,Integer> {
}
