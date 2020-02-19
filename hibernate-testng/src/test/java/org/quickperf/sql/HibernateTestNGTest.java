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

package org.quickperf.sql;

import football.PlayerRepository;
import football.entity.Player;
import net.ttddyy.dsproxy.support.ProxyDataSource;
import org.quickperf.sql.annotation.ExpectSelect;
import org.quickperf.sql.config.QuickPerfSqlDataSourceBuilder;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.quickperf.sql.config.HibernateEntityManagerBuilder.anHibernateEntityManager;
import static org.quickperf.sql.config.TestDataSourceBuilder.aDataSource;

public class HibernateTestNGTest {

    @ExpectSelect(1)
    @Test
    public void should_find_all_players() {

        PlayerRepository playerRepository = new PlayerRepository(entityManager);

        List<Player> players = playerRepository.findAll();

        assertThat(players).hasSize(2);

    }

    private EntityManager entityManager;

    {
        DataSource dataSource = aDataSource().build();
        ProxyDataSource proxyDataSource = QuickPerfSqlDataSourceBuilder.aDataSourceBuilder()
                .buildProxy(dataSource);
        entityManager = anHibernateEntityManager(proxyDataSource);
    }

}
