package org.football.player.footballplayer.controller;

import org.football.player.footballplayer.dto.PostPlayerbasicinfoRequestDto;
import org.football.player.footballplayer.model.Playerbasicinfo;
import org.football.player.footballplayer.repository.FootballplayerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@DataJpaTest
// slice test + integration test
//@WebMvcTest(FootBallPlayerController.class)
// integration test
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FootballPlayerControllerTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    FootballplayerRepository footballplayerRepository;

    @Test
    public void CheckTestDB() throws SQLException {
        try(Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getURL());
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getUserName());
        }
    }

    @Test
    public void GetTest() throws SQLException{
        Playerbasicinfo playerBasicInfo = new Playerbasicinfo();
        playerBasicInfo.setPlayername("son");
        playerBasicInfo.setNationality("korea");

        Playerbasicinfo playerbasicinfoFromH2 = footballplayerRepository.save(playerBasicInfo);
        Playerbasicinfo existingPlayer = footballplayerRepository.findByPlayername(playerBasicInfo.getPlayername());
        Playerbasicinfo existingPlayerWithNationality = footballplayerRepository
                .findByPlayernameAndNationality(playerBasicInfo.getPlayername(),playerBasicInfo.getNationality());
        assertThat(existingPlayerWithNationality).isNotNull();
        assertThat(existingPlayer).isNotNull();

        Playerbasicinfo nonExistingPlayer = footballplayerRepository
                .findByPlayernameAndNationality("honda","japan");
        assertThat(nonExistingPlayer).isNull();
    }

    @Test
    public void PostTest() throws SQLException {
        PostPlayerbasicinfoRequestDto requestDto = PostPlayerbasicinfoRequestDto
                .builder()
                .nationality("korea")
                .playername("son")
                .build();

        PostPlayerbasicinfoRequestDto requestDto2 = PostPlayerbasicinfoRequestDto
                .builder()
                .playername("pogba")
                .nationality("france")
                .build();


        Long id1 = footballplayerRepository.save(requestDto.toEntity()).getId();
        Long id2 = footballplayerRepository.save(requestDto2.toEntity()).getId();
        var testData = footballplayerRepository.findById(id1);
        assertThat(requestDto.toEntity().getPlayername()).isEqualTo(testData.get().getPlayername());
        assertThat(requestDto.toEntity().getNationality()).isEqualTo(testData.get().getNationality());
        assertThat(testData.get().getId()).isNotNull();

        var testData2 = footballplayerRepository.findById(id2);
        assertThat(requestDto2.toEntity().getPlayername()).isEqualTo(testData2.get().getPlayername());
        assertThat(requestDto2.toEntity().getNationality()).isEqualTo(testData2.get().getNationality());
        assertThat(testData2.get().getId()).isEqualTo(2);


    }
}