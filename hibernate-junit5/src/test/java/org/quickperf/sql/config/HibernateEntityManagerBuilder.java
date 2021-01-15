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

package org.quickperf.sql.config;

import football.entity.Player;
import football.entity.Team;
import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.persistence.spi.ClassTransformer;
import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class HibernateEntityManagerBuilder {

    private HibernateEntityManagerBuilder() {}

    public static EntityManager anHibernateEntityManager(DataSource dataSource) {
        HibernateEntityManagerBuilder builder = new HibernateEntityManagerBuilder();

        builder.dataSource = dataSource;
        PersistenceProvider persistenceProvider = builder.persistenceProvider;
        EntityManagerFactory entityManagerFactory = persistenceProvider.createContainerEntityManagerFactory(builder.persistenceUnitInfo
                , new HashMap<>());

        return entityManagerFactory.createEntityManager();
    }

    private final PersistenceProvider persistenceProvider = new HibernatePersistenceProvider();

    private DataSource dataSource;

    private final PersistenceUnitInfo persistenceUnitInfo =  new PersistenceUnitInfo(){

        @Override
        public String getPersistenceUnitName() {
            return "my pu";
        }

        @Override
        public String getPersistenceProviderClassName() {
            return "org.hibernate.jpa.HibernatePersistenceProvider";
        }

        @Override
        public PersistenceUnitTransactionType getTransactionType() {
            return PersistenceUnitTransactionType.RESOURCE_LOCAL;
        }

        @Override
        public DataSource getJtaDataSource() {
            return null;
        }

        @Override
        public DataSource getNonJtaDataSource() {
            return dataSource;
        }

        @Override
        public List<String> getMappingFileNames() {
            return emptyList();
        }

        @Override
        public List<URL> getJarFileUrls() {
            return emptyList();
        }

        @Override
        public URL getPersistenceUnitRootUrl() {
            return null;
        }

        @Override
        public List<String> getManagedClassNames() {
            return persistentClasses().stream().map(c -> c.getName()).collect(toList());
        }

        @Override
        public boolean excludeUnlistedClasses() {
            return false;
        }

        @Override
        public SharedCacheMode getSharedCacheMode() {
            return SharedCacheMode.NONE;
        }

        @Override
        public ValidationMode getValidationMode() {
            return ValidationMode.NONE;
        }

        @Override
        public Properties getProperties() {

            Properties config = new Properties();

            config.put("hibernate.show_sql", false);
            config.put("hibernate.format_sql", false);

            config.put("hibernate.jdbc.batch_size", 25);

            config.setProperty("hibernate.hbm2ddl.auto", "create");
            config.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

            return config;
        }

        @Override
        public String getPersistenceXMLSchemaVersion() {
            return "2.1";
        }

        @Override
        public ClassLoader getClassLoader() {
            return this.getClass().getClassLoader();
        }

        @Override
        public void addTransformer(ClassTransformer transformer) {

        }

        @Override
        public ClassLoader getNewTempClassLoader() {
            return this.getClass().getClassLoader();
        }
    };

    private List<Class<?>> persistentClasses() {
        return Arrays.asList(Player.class, Team.class);
    }

}
