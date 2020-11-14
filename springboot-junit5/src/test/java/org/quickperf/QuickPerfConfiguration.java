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

package org.quickperf;

import org.quickperf.config.SpecifiableGlobalAnnotations;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;

import static org.quickperf.sql.annotation.SqlAnnotationBuilder.*;

/**
 * This class configures global annotations that is to say annotations applying on
 * each test.
 */
public class QuickPerfConfiguration implements SpecifiableGlobalAnnotations {

    public Collection<Annotation> specifyAnnotationsAppliedOnEachTest() {

        return Arrays.asList(
                // Can reveal some N+1 selects
                // https://blog.jooq.org/2017/12/18/the-cost-of-jdbc-server-roundtrips/
                disableSameSelectTypesWithDifferentParams()

                , // Sometimes, JDBC batching can be disabled:
                // https://abramsm.wordpress.com/2008/04/23/hibernate-batch-processing-why-you-may-not-be-using-it-even-if-you-think-you-are/
                // https://stackoverflow.com/questions/27697810/hibernate-disabled-insert-batching-when-using-an-identity-identifier
                expectJdbcBatching()

                , // https://use-the-index-luke.com/sql/where-clause/searching-for-ranges/like-performance-tuning
                disableLikeWithLeadingWildcard()

                , disableSameSelects()

                // Not relevant with an in-memory database used for testing purpose
                , expectMaxQueryExecutionTime( 30)

                , disableStatements()

                , disableQueriesWithoutBindParameters()

        );

    }

}