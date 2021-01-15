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

package org.quickperf.micronaut.micronauttest.service;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.quickperf.junit5.QuickPerfTest;
import org.quickperf.micronaut.micronauttest.dto.PlayerWithTeamName;
import org.quickperf.sql.annotation.ExpectSelect;

import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
@QuickPerfTest
public class PlayerServiceTest {

    @Inject
    private PlayerService playerService;

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