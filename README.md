<div align="center">
<img src="https://pbs.twimg.com/profile_banners/926219963333038086/1518645789" alt="QuickPerf"/>
</div>

# QuickPerf examples

This repository contains several projects showing how to use QuickPerf [JVM](https://github.com/quick-perf/doc/wiki/JVM-annotations) and [SQL](https://github.com/quick-perf/doc/wiki/SQL-annotations) annotations with various frameworks (*JUnit 4*, *JUnit 5*, *TestNG*, *Testcontainers*, *Spring Boot*, *Quarkus*, *Micronaut*, ...).

[How to run the examples](#How-to-run-the-examples) <br><br>
[JVM annotations](#JVM-annotations) <br><br>
[Hibernate without Spring](#Hibernate-without-Spring) <br><br>
[Spring Boot](#Spring-Boot) <br><br>
[Micronaut](#Micronaut) <br><br>
[Quarkus](#Quarkus) <br><br>
[Testcontainers](#Testcontainers)

## How to run the examples

## Online

Run the examples with an online interactive guide: [![try it online](https://www.eclipse.org/che/contribute.svg)](che-didact-guide)

## From your computer
*[QuickPerf artifacts are published to Maven central](https://search.maven.org/search?q=org.quickperf).*

Execute the following command lines:

*Windows*
```
  git clone https://github.com/quick-perf/quickperf-examples.git
  cd quickperf-examples
  mvnw.cmd compile
```

*Mac or Linux or Windows with Git Bash*
```
  git clone https://github.com/quick-perf/quickperf-examples.git
  cd quickperf-examples
  ./mvnw compile
```

Import the _quickperf-examples_ project in your IDE.

You can now execute the test methods from your IDE.

Tests are skiped by default as they will all fail, if you want to execute them via Maven you need to use 
`mvn clean test -Dmaven.test.skip=false -Dmaven.test.failure.ignore`.

## JVM annotations

**[jvm-junit4](jvm-junit4/src/test/java/org/quickperf/jvm)**<br>
Examples showing how to use some **JVM annotations** with **JUnit 4**

**[jvm-junit5](jvm-junit5/src/test/java/org/quickperf/jvm)**<br>
Examples showing how to use some **JVM annotations** with **JUnit 5**

**[jvm-testng](jvm-testng/src/test/java/org/quickperf/jvm)**<br>
Examples showing how to use some **JVM annotations** with **TestNG**

## Hibernate without Spring

**[hibernate-junit4](hibernate-junit4)**<br>
Examples showing how to use some SQL annotations with **Hibernate** and **JUnit 4**

**[hibernate-junit5](hibernate-junit5)**<br>
Examples showing how to use some SQL annotations with **Hibernate** and **JUnit 5**

**[hibernate-postgresql-testcontainers-junit5](tc-postgresql-hibernate-junit5)**<br>
Examples showing how to use some SQL annotations with **Hibernate**, **JUnit 5**, **PostgreSQL** and [**Testcontainers**](https://www.testcontainers.org)

**[hibernate-mariadb-testcontainers-junit5](tc-mariadb-hibernate-junit5)**<br>
Examples showing how to use some SQL annotations with **Hibernate**, **JUnit 5**, **MariaDB** and [**Testcontainers**](https://www.testcontainers.org)

**[hibernate-testng](hibernate-testng)**<br>
Examples showing how to use some SQL annotations with **Hibernate** and **TestNG**

## Spring Boot
**[springboot-junit4](springboot-junit4)**<br>
This **Spring Boot** project illustrates how to use QuickPerf with **JUnit 4** 

**[springboot-junit5](springboot-junit5)**<br>
This **Spring Boot** project illustrates how to use QuickPerf with **JUnit 5**

**[testcontainers-springboot-junit5](tc-springboot-junit5)**<br>
This **Spring Boot** project illustrates how to use QuickPerf with **JUnit 5** and [**Testcontainers**](https://www.testcontainers.org)

## Micronaut
**[micronaut-hibernate-jpa](micronaut-hibernate-jpa)**<br>
This **Micronaut/Hibernate/JPA** project illustrates how to use QuickPerf with **JUnit 5** 

**[micronaut-data-jdbc](micronaut-data-jdbc)**<br>
This **Micronaut/Data JDBC** project illustrates how to use QuickPerf with **JUnit 5**

## Quarkus
**[quarkus](quarkus)**<br>
This **Quarkus** project illustrates how to use QuickPerf with **JUnit 5** for SQL annotations only

## Testcontainers

**[hibernate-postgresql-testcontainers-junit5](tc-postgresql-hibernate-junit5)**<br>
Examples showing how to use some SQL annotations with **Hibernate**, **JUnit 5**, **PostgreSQL** and [**Testcontainers**](https://www.testcontainers.org)

**[hibernate-mariadb-testcontainers-junit5](tc-mariadb-hibernate-junit5)**<br>
Examples showing how to use some SQL annotations with **Hibernate**, **JUnit 5**, **MariaDB** and [**Testcontainers**](https://www.testcontainers.org)

**[testcontainers-springboot-junit5](tc-springboot-junit5)**<br>
This **Spring Boot** project illustrates how to use QuickPerf with **JUnit 5** and [**Testcontainers**](https://www.testcontainers.org) 