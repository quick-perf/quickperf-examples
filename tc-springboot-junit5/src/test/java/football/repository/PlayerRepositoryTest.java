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

import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.quickperf.junit5.QuickPerfTest;
import org.quickperf.sql.annotation.ExpectSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.testcontainers.containers.MariaDBContainer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = PlayerRepositoryTest.Initializer.class)
@Import(QuickPerfBeanConfig.class)
@QuickPerfTest
public class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @ClassRule
    public static MariaDBContainer db = new MariaDBContainer("mariadb:10.5.2");


     /* FIRST TYPE OF N+1 SELECT
    We expect to retrieve all the players from the database with one SELECT statement.
    This is verified with the help of an @ExpectSelect(1) QuickPerf annotation added on
    test method.
    Let's execute this test method. This test is failing!
    In the bottom of the error report, the SQL executions are displayed. We have one
    SELECT statement on Player table, and two more on Team table. For each player a
    SELECT statement is executed to retrieve his team. We have a N+1 select issue as
    suggested by the error report: "Perhaps you are facing a N+1 select issue".
    The error report proposes several ways of fixing an N+1 SELECT.
    In this case, in the Player entity, let's specify a lazy fetch type for the
    relationship between the players and their team:
          @ManyToOne(targetEntity = Team.class, fetch = FetchType.LAZY)
          @JoinColumn(name = "team_id")
          private Team team;
    If you run the test with this modification, it will be green!
    */

    @ExpectSelect(1)
    @Test
    public void should_find_all_players() {
        List<Player> players = playerRepository.findAll();
        assertThat(players).hasSize(2);
    }

    public static class Initializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            db.start();
            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(configurableApplicationContext, "spring.datasource.url=" + db.getJdbcUrl());
            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(configurableApplicationContext, "spring.datasource.username=" + db.getUsername());
            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(configurableApplicationContext, "spring.datasource.password=" + db.getPassword());
            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(configurableApplicationContext, "spring.datasource.driver-class-name=" + db.getDriverClassName());
            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(configurableApplicationContext, "spring.jpa.properties.hibernate.show_sql=true");
            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(configurableApplicationContext, "spring.jpa.hibernate.ddl-auto=create-drop");
            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(configurableApplicationContext, "spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
        }
    }

}
