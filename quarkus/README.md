Quarkus Hibernate JPA with JUnit5 test using QuickPerf SQL annotations. 

At the beginning of each test, a SQL script defined in the [import.sql](src/test/resources/import.sql) file is executed.
This script inserts two players and their team in the database.

Global annotations are configured in [QuickPerfConfiguration](src/test/java/org/quickperf/QuickPerfConfiguration.java). These annotations apply on each test.

For QuickPerf to be able to spy on your SQL requests, it needs a way to proxy your DataSource via [ttddyy](https://github.com/ttddyy/datasource-proxy).
In this example, this is done inside the [QuickperfDriver](src/test/java/org/quickperf/quarkus/quarkustest/sql/QuickperfDriver.java) SQL driver that will proxy your DataSource.

This SQL driver is then used instead of your SQL driver inside the [application.properties](src/main/resources/application.properties) of your application.
This is a proxy driver, it uses a custom DataSource URL scheme, and will delegates everything to the real driver. 
When using it, the Hibernate dialect needs to be set explicitly, because Hibernate will not be able to derive it due to the custom URL scheme.
