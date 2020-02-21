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

import football.dto.PlayerWithTeamName;
import football.entity.Player;
import net.ttddyy.dsproxy.support.ProxyDataSource;
import org.junit.jupiter.api.Test;
import org.quickperf.annotation.DisableGlobalAnnotations;
import org.quickperf.junit5.QuickPerfTest;
import org.quickperf.sql.annotation.ExpectSelect;
import org.quickperf.sql.config.QuickPerfSqlDataSourceBuilder;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.quickperf.sql.config.HibernateEntityManagerBuilder.anHibernateEntityManager;
import static org.quickperf.sql.config.TestDataSourceBuilder.aDataSource;

@QuickPerfTest
public class HibernateJUnit5Test {

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
    @DisableGlobalAnnotations // Global annotations are explained with the
    // second test method. Global annotations are
    // disabled here to explain one thing at a time.
    @Test
    public void should_find_all_players() {

        TypedQuery<Player> fromPlayer
                = entityManager.createQuery("FROM Player", Player.class);

        List<Player> players = fromPlayer.getResultList();

        assertThat(players).hasSize(2);

    }

    // In the previous example, the outcome of the N+1 select was to have additional
    // SELECT statements on Team table. These additional SELECT statements are the same
    // apart from the id value of the Team table.
    //
    // With QuickPerf, you can easily detect that the same SELECT statements with different
    // values are executed, allowing to catch N+1 selects. We are going to see this in the
    // example.

    //-------------------------------------------------------------------------------------

    /* SECOND TYPE OF N+1 SELECT

    This test method is not annotated with a QuickPerf annotation. However, it will
    fail because N+1 select is detected from a global annotation defined in
    org.quickperf.QuickPerfConfiguration class: disableSameSelectTypesWithDifferentParams
    Global apply on each test method.

    This comes from the following Java code:
        List<PlayerWithTeamName> playersWithTeamName =
                 players
                .stream()
                .map(player -> new PlayerWithTeamName(
                                player.getFirstName()
                                , player.getLastName()
                                , player.getTeam().getName()
                        )
                )
                .collect(Collectors.toList());

    Each time the getName() method is called, a SELECT... FROM Team statement is sent to
    the database.

    This type of N+1 SELECT can't be solved by configuring a LAZY fetch type.

    To fix this N+1 SELECT, you can use JOIN FETCH or a LEFT JOIN FETCH:
        TypedQuery<Player> fromPlayer
                = entityManager.createQuery("FROM Player p LEFT JOIN FETCH p.team", Player.class);TypedQuery<Player> fromPlayer

    These solutions are suggested by the QuickPerf error report.

    Global annotations apply on each test. In the case where you are developing a new feature,
    perhaps with the help of TDD, your test may fail because the business property is
    un-respected but also because some performance properties checked by global annotations
    are un-respected. In order to do one step at a time, you can temporarily disable global
    annotations by applying @FunctionalIteration or @DisableQuickPerf or @DisableGlobalAnnotations
    at method level.

    You can use @FunctionalIteration or @DisableQuickPerf to disable QuickPerf
    features and focus on functional behavior (not performance behavior) in a first
    step. In a second step, you can remove @FunctionalIteration or @DisableQuickPerf
    to evaluate some performance properties. We recommend to do one step at a time.
    */
    //@FunctionalIteration //Uncomment this line to disable QuickPerf features
    @Test
    public void should_find_all_players_with_their_team_name() {

        TypedQuery<Player> fromPlayer
                = entityManager.createQuery("FROM Player", Player.class);

        List<Player> players = fromPlayer.getResultList();

        List<PlayerWithTeamName> playersWithTeamName =
                players
                        .stream()
                        .map(player -> new PlayerWithTeamName(
                                        player.getFirstName()
                                        , player.getLastName()
                                        , player.getTeam().getName()
                                )
                        )
                        .collect(Collectors.toList());

        assertThat(playersWithTeamName).hasSize(2);

    }

    //-------------------------------------------------------------------------------------

    private EntityManager entityManager;

    {
        DataSource dataSource = aDataSource().build();

        // A data source proxy is built to allow QuickPerf to intercept the SQL statements
        ProxyDataSource proxyDataSource = QuickPerfSqlDataSourceBuilder.aDataSourceBuilder()
                .buildProxy(dataSource);

        entityManager = anHibernateEntityManager(proxyDataSource);
    }

}
