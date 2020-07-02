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

package football.controller;

import football.FootballApplication;
import org.junit.jupiter.api.Test;
import org.quickperf.junit5.QuickPerfTest;
import org.quickperf.sql.annotation.ExpectSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {FootballApplication.class})
@AutoConfigureMockMvc
@QuickPerfTest
public class PlayerControllerWithMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    /*
    This test is annoted with @ExpectSelect(1), that is to say that this test should only generate 1 sql 
    request.

    This type of N+1 SELECT can't be solved by configuring a LAZY fetch type only it has to use 
    @EntityGraph in order to fetch an load accordinly
    https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.entity-graph
.
    To fix this N+1 SELECT, you can use should:

    1. update Player with NamedEntityGraph
    ...
        @Entity
        @NamedEntityGraph(name = "graph.Player.team", 
            attributeNodes = @NamedAttributeNode("team"))
        public class Player implements Serializable {
        ...
            @ManyToOne(targetEntity = Team.class, fetch = FetchType.LAZY)
            private Team team;
        ...
        }
    2 add EntityGraph to PlayerRepository
    ...
       @Repository
        public interface PlayerRepository extends JpaRepository<Player, Long> {
            @EntityGraph(value = "GroupInfo.detail", type = EntityGraphType.LOAD)
            List<Player> findAll();
        }

    These solutions are suggested by the QuickPerf error report.
    Global annotations apply on each test. In the case where you are developing a new feature,
    perhaps with the help of TDD, your test may fail because the business property is
    un-respected but also because some performance properties checked by global annotations
    are un-respected. In order to do one step at a time, you can temporarily disable global
    annotations by applying @FunctionalIteration or @DisableQuickPerf or @DisableGlobalAnnotations
    at method level.
     */
    @ExpectSelect(1)
    @Test
    public void should_find_all_players() throws Exception {
        mockMvc.perform(get("/players"))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("Pogba")))
               .andExpect(content().string(containsString("Griezmann")));
    }

}