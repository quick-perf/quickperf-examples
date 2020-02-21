This **Spring Boot project** illustrates how to use **QuickPerf** with **JUnit 4** during testing of a *repository*, a *service* or a *controller*.<br><br>

At the beginning of each test, a SQL script defined in the [import.sql](src/test/resources/import.sql) file is executed.
This script inserts two players and their team in the database.

Global annotations are configured in [QuickPerfConfiguration](src/test/java/org/quickperf/QuickPerfConfiguration.java). These annotations apply on each test.
