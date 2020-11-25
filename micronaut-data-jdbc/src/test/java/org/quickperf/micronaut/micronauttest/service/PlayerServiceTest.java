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

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.quickperf.junit5.QuickPerfTest;
import org.quickperf.micronaut.micronauttest.dto.PlayerWithTeamName;
import org.quickperf.micronaut.micronauttest.jdbc.entity.Player;
import org.quickperf.micronaut.micronauttest.jdbc.entity.Team;
import org.quickperf.micronaut.micronauttest.jdbc.repository.PlayerRepository;
import org.quickperf.micronaut.micronauttest.jdbc.repository.TeamRepository;

import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
@QuickPerfTest
public class PlayerServiceTest {

    @Inject
    private PlayerService playerService;

    @Inject
    private PlayerRepository playerRepository;

    @Inject
    private TeamRepository teamRepository;

    @BeforeEach
    public void before() {

        Team team1 = new Team();
        team1.setId(1L);
        team1.setName("Manchester United");
        teamRepository.save(team1);

        Team team2 = new Team();
        team2.setId(2L);
        team2.setName("Atlético de Madrid'");
        teamRepository.save(team2);

        Player player1 = new Player();
        player1.setId(1L);
        player1.setFirstName("Paul");
        player1.setLastName("Pogba");
        player1.setTeam(team1);
        playerRepository.save(player1);

        Player player2 = new Player();
        player2.setId(2L);
        player2.setFirstName("Antoine");
        player2.setLastName("Griezmann");
        player2.setTeam(team2);
        playerRepository.save(player2);

    }

    /*
    This test method is not annotated with a QuickPerf annotation. However, it will
    fail because N+1 select is detected from disableSameSelectTypesWithDifferentParams
    defined in org.quickperf.QuickPerfConfiguration class.

    You can use @FunctionalIteration or @DisableQuickPerf to disable QuickPerf
    features and focus on functional behavior (not performance behavior) in a first
    step. In a second step, you can remove @FunctionalIteration or @DisableQuickPerf
    to evaluate some performance properties. We recommend to do one step at a time.
    */
    //@FunctionalIteration //Uncomment this line to disable QuickPerf features
    @Test
    public void should_find_all_players_with_team_name() {

        List<PlayerWithTeamName> playersWithTeamName = playerService.findPlayersWithTeamName();

        assertThat(playersWithTeamName).hasSize(2);

    }

}