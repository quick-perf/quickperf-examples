package org.quickperf.micronaut.micronauttest.jdbc.repository;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import org.quickperf.micronaut.micronauttest.jdbc.entity.Team;

@JdbcRepository(dialect = Dialect.H2)
public interface TeamRepository extends CrudRepository<Team, Long> {
}
