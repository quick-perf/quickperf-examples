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

package org.quickperf.quarkus.quarkustest.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.quickperf.annotation.DisableGlobalAnnotations;
import org.quickperf.junit5.QuickPerfTest;
import org.quickperf.sql.annotation.ExpectSelect;

import static io.restassured.RestAssured.given;

@QuarkusTest
@QuickPerfTest
public class PlayerControllerTest {

    @DisableGlobalAnnotations // Global annotations are used in the PlayerServiceTest
                              // They are disabled here to use explicit annotations instead
    @ExpectSelect(1)
    @Test
    public void should_find_all_players() {
        given()
                .when().get("/players")
                .then()
                .statusCode(200)
                .body("size()", CoreMatchers.is(2));
    }

}