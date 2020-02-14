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

package org.quickperf.quarkus.quarkustest.service;

import org.quickperf.quarkus.quarkustest.dto.PlayerWithTeamName;
import org.quickperf.quarkus.quarkustest.jpa.entity.Player;
import org.quickperf.quarkus.quarkustest.jpa.repository.PlayerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PlayerService {

    private PlayerRepository playerRepository;

    PlayerService() {

    }


    @Inject
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Transactional
    public List<PlayerWithTeamName> findPlayersWithTeamName() {
        List<Player> players = playerRepository.listAll();
        return  players
               .stream()
               .map(player -> new PlayerWithTeamName(
                                    player.getFirstName()
                                  , player.getLastName()
                                  , player.getTeam().getName()
                              )
                    )
               .collect(Collectors.toList());
    }

}
