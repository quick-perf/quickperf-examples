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

@SpringBootTest(
  classes = {FootballApplication.class}
, properties = "spring.datasource.data=classpath:import-teams.sql"
                                   + ",classpath:import-players.sql"
)
@AutoConfigureMockMvc
public class PlayerControllerWithMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @ExpectSelect(1)
    @Test
    public void should_find_all_players() throws Exception {
        mockMvc.perform(get("/players"))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("Pogba")))
               .andExpect(content().string(containsString("Griezmann")));
    }

}