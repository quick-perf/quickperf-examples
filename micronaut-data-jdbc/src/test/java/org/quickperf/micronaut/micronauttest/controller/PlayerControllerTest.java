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
 * Copyright 2020-2021 the original author or authors.
 */

package org.quickperf.micronaut.micronauttest.controller;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.quickperf.junit5.QuickPerfTest;
import org.quickperf.jvm.allocation.AllocationUnit;
import org.quickperf.jvm.annotations.HeapSize;
import org.quickperf.micronaut.micronauttest.dto.PlayerWithTeamName;
import org.quickperf.micronaut.micronauttest.jdbc.entity.Player;
import org.quickperf.micronaut.micronauttest.jdbc.entity.Team;
import org.quickperf.micronaut.micronauttest.jdbc.repository.PlayerRepository;
import org.quickperf.micronaut.micronauttest.jdbc.repository.TeamRepository;
import org.quickperf.sql.annotation.ExpectSelect;

import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
@QuickPerfTest
public class PlayerControllerTest {

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

    @Inject
    @Client("/")
    private RxHttpClient client;

    @ExpectSelect(1)
    @HeapSize(value = 50, unit = AllocationUnit.MEGA_BYTE)
    @Test
    public void should_find_all_players() {

        // GIVEN
        String uri = "/players";

        // WHEN
        List<PlayerWithTeamName> players = client.toBlocking().retrieve(HttpRequest.GET(uri), Argument.of(List.class, PlayerWithTeamName.class));

        // THEN
        assertThat(players).hasSize(2);

    }

}