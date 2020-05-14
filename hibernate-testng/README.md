This project illustrates how to use **QuickPerf** with **Hibernate** and **TestNG** 

At the beginning of each test, a SQL script defined in the [import.sql](src/test/resources/import.sql) file is executed.
This script inserts two players and their team in the database.

Global annotations are configured in [QuickPerfConfiguration](src/test/java/org/quickperf/QuickPerfConfiguration.java). These annotations apply on each test.

For QuickPerf to be able to spy on your SQL requests, it needs a way to proxy you DataSource via [ttddyy](https://github.com/ttddyy/datasource-proxy).
In this example, this is done inside the [HibernateTestNGTest](src/test/java/org/quickperf/sql/HibernateTestNGTest.java) test class via an initializer block.