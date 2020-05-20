/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2020-2020 the original author or authors.
 */

package org.quickperf.micronaut.micronauttest.service;

import org.quickperf.micronaut.micronauttest.dto.PlayerWithTeamName;
import org.quickperf.micronaut.micronauttest.jdbc.entity.Player;
import org.quickperf.micronaut.micronauttest.jdbc.entity.Team;
import org.quickperf.micronaut.micronauttest.jdbc.repository.PlayerRepository;
import org.quickperf.micronaut.micronauttest.jdbc.repository.TeamRepository;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Singleton
public class PlayerService {

    private PlayerRepository playerRepository;
    private TeamRepository teamRepository;

    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @PostConstruct
    void initData(){
        // import.sql is not loaded with micronaut-data so we create the data upfront
        /*
        INSERT INTO team VALUES (1, 'Manchester United');
        INSERT INTO team VALUES (2, 'Atlético de Madrid');

        INSERT INTO player VALUES (1, 'Paul', 'Pogba', 1);
        INSERT INTO player VALUES (2, 'Antoine', 'Griezmann', 2);
         */
        Team team1 = new Team();
        team1.setId(1L);
        team1.setName("Manchester United");
        Team team2 = new Team();
        team2.setId(2L);
        team2.setName("Atlético de Madrid'");
        Player player1 = new Player();
        player1.setId(1L);
        player1.setFirstName("Paul");
        player1.setLastName("Pogba");
        player1.setTeam(team1);
        Player player2 = new Player();
        player2.setId(2L);
        player2.setFirstName("Antoine");
        player2.setLastName("Griezmann");
        player2.setTeam(team2);

        teamRepository.save(team1);
        teamRepository.save(team2);
        playerRepository.save(player1);
        playerRepository.save(player2);
    }

    public List<PlayerWithTeamName> findPlayersWithTeamName() {
        Iterable<Player> players = playerRepository.findAll();
        return StreamSupport.stream(players.spliterator(), false)
               .map(player -> {
                   // This is wrong, we should use a @Join instead of a second repository to avoid n+1 query
                   Team team = teamRepository.findById(player.getTeam().getId()).get();
                   return new PlayerWithTeamName(
                                    player.getFirstName()
                                  , player.getLastName()
                                  , team.getName()
                              );
                    })
               .collect(Collectors.toList());
    }

}
