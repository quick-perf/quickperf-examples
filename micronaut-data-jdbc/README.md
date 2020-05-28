Micronaut Data JDBC with JUnit5 test using QuickPerf SQL annotations. 

When launching the application, the [PlayerService.java](src/main/java/org/quickperf/micronaut/micronauttest/service/PlayerService.java) save test data inside the database.

Global annotations are configured in [QuickPerfConfiguration](src/test/java/org/quickperf/QuickPerfConfiguration.java). These annotations apply on each test.

For QuickPerf to be able to spy on your SQL requests, it needs a way to proxy your DataSource via [ttddyy](https://github.com/ttddyy/datasource-proxy).
In this example, this is done inside the [QuickperfDriver](src/test/java/org/quickperf/micronaut/micronauttest/sql/QuickperfDriver.java) SQL driver that will proxy your DataSource.

This SQL driver is then used instead of your SQL driver inside the [application.yml](src/main/resources/application.yml) of your application.
This is a proxy driver, it uses a custom DataSource URL scheme, and will delegates everything to the real driver. 