
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
