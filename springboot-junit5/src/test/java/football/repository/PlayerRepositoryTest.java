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

import football.QuickPerfBeanConfig;
import football.entity.Player;
import org.junit.jupiter.api.Test;
import org.quickperf.junit5.QuickPerfTest;
import org.quickperf.sql.annotation.ExpectSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Import(QuickPerfBeanConfig.class)
@DataJpaTest()
@QuickPerfTest
public class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    //@FunctionalIteration // You can use @FunctionalIteration or @DisableQuickPerf
    // to disable QuickPerf features and focus on functional
    // behavior (not performance behavior) in a first step.
    // In a second step, you can remove @FunctionalIteration
    // or @DisableQuickPerf to evaluate some performance
    // properties.
    // We recommend to do one step at a time.
    // The test will fail because N+1 select is detected from
    // disableSameSelectTypesWithDifferentParams defined in QuickPerfConfiguration
    // class.
    @ExpectSelect(1)
    //@FunctionalIteration
    @Test
    public void should_find_all_players() {
        List<Player> players = playerRepository.findAll();
        assertThat(players).hasSize(2);
    }

}
