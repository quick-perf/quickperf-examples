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

package org.quickperf.sql.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.testcontainers.containers.JdbcDatabaseContainer;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDataSourceBuilder {

    private TestDataSourceBuilder() { }

    public static TestDataSourceBuilder aDataSource() {
        return new TestDataSourceBuilder();
    }

    public DataSource build(final JdbcDatabaseContainer jdbc) {
        final BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(jdbc.getDriverClassName());
        dataSource.setUrl(jdbc.getJdbcUrl());
        dataSource.setUsername(jdbc.getUsername());
        dataSource.setPassword(jdbc.getPassword());
        dataSource.setMaxActive(4);
        dataSource.setPoolPreparedStatements(true);
        return dataSource;
    }

}
