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

package football.repository;

import football.entity.Player;
import football.entity.Team;
import org.junit.jupiter.api.Test;
import org.quickperf.junit5.QuickPerfTest;
import org.quickperf.spring.sql.QuickPerfSpringConfig;
import org.quickperf.sql.annotation.ExpectJdbcBatching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Arrays;
import java.util.List;

@Import(QuickPerfSpringConfig.class)
@DataJpaTest(properties = "spring.datasource.data=classpath:import-teams.sql")
public class PlayerRepositoryBatchTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    @ExpectJdbcBatching()
    void should_insert_in_batch() {

        Team team = aTeam();
        List<Player> teams = Arrays.asList(aNewPlayer(team), aNewPlayer(team));

        playerRepository.saveAll(teams);

        System.out.println("Retrieve all players");

        playerRepository.flush();

    }

    private Team aTeam() {
        Team team = new Team();
        team.setId(1L);
        return team;
    }

    private Player aNewPlayer(Team team) {
        Player player = new Player();
        player.setFirstName("someFirstName");
        player.setLastName("someLastName");
        player.setTeam(team);
        return player;
    }

}
