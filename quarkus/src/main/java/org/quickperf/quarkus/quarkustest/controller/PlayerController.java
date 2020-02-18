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

import org.quickperf.quarkus.quarkustest.dto.PlayerWithTeamName;
import org.quickperf.quarkus.quarkustest.service.PlayerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/players")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerController {

    @Inject PlayerService playerService;

    @GET
    public List<PlayerWithTeamName> findAll() {
        return playerService.findPlayersWithTeamName();
    }

}
