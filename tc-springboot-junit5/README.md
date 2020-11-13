This **Spring Boot project** illustrates how to use **QuickPerf** with **JUnit 5** during testing of a *repository*, a *service* or a *controller*.<br><br>

At the beginning of each test, a SQL script defined in the [import.sql](src/test/resources/import.sql) file is executed.
This script inserts two players and their team in the database.

Global annotations are configured in [QuickPerfConfiguration](src/test/java/org/quickperf/QuickPerfConfiguration.java). These annotations apply on each test.

For QuickPerf to be able to spy on your SQL requests, it needs a way to proxy your DataSource via [ttddyy](https://github.com/ttddyy/datasource-proxy).
In this example, this is done with QuickPerfSqlConfig that is part of the `org.quickperf:quick-perf-sql-spring5` library.
