<div align="center">
<img src="https://pbs.twimg.com/profile_banners/926219963333038086/1518645789" alt="QuickPerf"/>
</div>

# QuickPerf examples
[![try it online](https://che.openshift.io/factory/resources/factory-contribute.svg)](https://che.openshift.io/f?url=https://github.com/quick-perf/quickperf-examples)

This repository contains several projects showing how to use QuickPerf [JVM](https://github.com/quick-perf/doc/wiki/JVM-annotations) and [SQL](https://github.com/quick-perf/doc/wiki/SQL-annotations) annotations with various frameworks (*JUnit 4*, *JUnit 5*, *TestNG*, *Testcontainers*, *Spring Boot*, *Quarkus*, *Micronaut*, ...).

[How to run the examples](#How-to-run-the-examples) <br><br>
[JVM annotations](#JVM-annotations) <br><br>
[Hibernate without Spring](#Hibernate-without-Spring) <br><br>
[Spring Boot](#Spring-Boot) <br><br>
[Micronaut](#Micronaut) <br><br>
[Quarkus](#Quarkus)

## How to run the examples
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
Examples showing how to use some **JVM annotations** with **JUnit 4**.

- [Open the org.quickperf.jvm.JvmAnnotationsJunit4Test class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fjvm-junit4%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fjvm%2FJvmAnnotationsJunit4Test.java)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=JvmAnnotationsJunit4Test.java)
- [Kick off the test @MeasureHeapAllocation](didact://?commandId=workbench.action.tasks.runTask&text=JvmAnnotationsJunit4Test.java%20%2F%20%40MeasureHeapAllocation)

**[jvm-junit5](jvm-junit5/src/test/java/org/quickperf/jvm)**<br>
Examples showing how to use some **JVM annotations** with **JUnit 5**.

- [Open the org.quickperf.jvm.JvmAnnotationsJunit5Test class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fjvm-junit5%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fjvm%2FJvmAnnotationsJunit5Test.java)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=JvmAnnotationsJunit5Test.java)
- [Kick off the test @MeasureHeapAllocation](didact://?commandId=workbench.action.tasks.runTask&text=JvmAnnotationsJunit5Test.java%20%2F%20%40MeasureHeapAllocation)

**[jvm-testng](jvm-testng/src/test/java/org/quickperf/jvm)**<br>
Examples showing how to use some **JVM annotations** with **TestNG**.

- [Open the org.quickperf.jvm.JvmAnnotationsTestNGTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fjvm-testng%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fjvm%2FJvmAnnotationsTestNGTest.java)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=JvmAnnotationsTestNGTest.java)
- [Kick off the test @MeasureHeapAllocation](didact://?commandId=workbench.action.tasks.runTask&text=JvmAnnotationsTestNGTest.java%20%2F%20%40MeasureHeapAllocation)


## Hibernate without Spring

**[hibernate-junit4](hibernate-junit4)**<br>
Examples showing how to use some SQL annotations with **Hibernate** and **JUnit 4**.

- [Open the org.quickperf.sql.HibernateJUnit4Test class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fhibernate-junit4%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fsql%2FHibernateJUnit4Test.java)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Hibernate%20JUnit%204)

**[hibernate-junit5](hibernate-junit5)**<br>
Examples showing how to use some SQL annotations with **Hibernate** and **JUnit 5**.

- [Open the org.quickperf.sql.HibernateJUnit5Test class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fhibernate-junit5%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fsql%2FHibernateJUnit5Test.java)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Hibernate%20JUnit%205)

**[hibernate-testng](hibernate-testng)**<br>
Examples showing how to use some SQL annotations with **Hibernate** and **TestNG**.

- [Open the org.quickperf.sql.HibernateTestNGTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fhibernate-testng%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fsql%2FHibernateTestNGTest.java)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Hibernate%20TestNG)

## Spring Boot
**[springboot-junit4](springboot-junit4)**<br>
This **Spring Boot** project illustrates how to use QuickPerf with **JUnit 4**. 

- [Open the football.controller.PlayerControllerTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fspringboot-junit4%2Fsrc%2Ftest%2Fjava%2Ffootball%2Fcontroller%2FPlayerControllerTest.java)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Spring%20Boot%20Contoller%20JUnit%204)
- [Open the football.service.PlayerServiceTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fspringboot-junit4%2Fsrc%2Ftest%2Fjava%2Ffootball%2Fservice%2FPlayerServiceTest.java)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Spring%20Boot%20Service%20JUnit%204)
- [Open the football.repository.PlayerRepositoryTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fspringboot-junit4%2Fsrc%2Ftest%2Fjava%2Ffootball%2Frepository%2FPlayerRepositoryTest.java)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Spring%20Boot%20Repository%20JUnit%204)


**[springboot-junit5](springboot-junit5)**<br>
This **Spring Boot** project illustrates how to use QuickPerf with **JUnit 5**. 

- [Open the football.controller.PlayerControllerTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fspringboot-junit5%2Fsrc%2Ftest%2Fjava%2Ffootball%2Fcontroller%2FPlayerControllerTest.java)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Spring%20Boot%20Contoller%20JUnit%205)
- [Open the football.service.PlayerServiceTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fspringboot-junit5%2Fsrc%2Ftest%2Fjava%2Ffootball%2Fservice%2FPlayerServiceTest.java)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Spring%20Boot%20Service%20JUnit%205)
- [Open the football.repository.PlayerRepositoryBatchTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fspringboot-junit5%2Fsrc%2Ftest%2Fjava%2Ffootball%2Frepository%2FPlayerRepositoryBatchTest.java)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Spring%20Boot%20Repository%20Batch%20JUnit%205)
- [Open the football.repository.PlayerRepositorySelectTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fspringboot-junit5%2Fsrc%2Ftest%2Fjava%2Ffootball%2Frepository%2FPlayerRepositorySelectTest.java)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Spring%20Boot%20Repository%20Select%20JUnit%205)


**[testcontainers-springboot-junit5](tc-springboot-junit5)**<br>
This **Spring Boot** project illustrates how to use QuickPerf with **JUnit 5** and [Testcontainers](https://www.testcontainers.org). 


## Micronaut
**[micronaut-hibernate-jpa](micronaut-hibernate-jpa)**<br>
This **Micronaut/Hibernate/JPA** project illustrates how to use QuickPerf with **JUnit 5**. 



**[micronaut-data-jdbc](micronaut-data-jdbc)**<br>
This **Micronaut/Data JDBC** project illustrates how to use QuickPerf with **JUnit 5**. 

- [Open the org.quickperf.micronaut.micronauttest.service.PlayerServiceTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fmicronaut-data-jdbc%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fmicronaut%2Fmicronauttest%2Fservice%2FPlayerServiceTest.java)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Micronaut%20Data%20N%2B1%20select)
- [Open the org.quickperf.micronaut.micronauttest.controller.PlayerControllerTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fmicronaut-data-jdbc%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fmicronaut%2Fmicronauttest%2Fcontroller%2FPlayerControllerTest.java)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Micronaut%20Data%20HTTP)



## Quarkus
**[quarkus](quarkus)**<br>
This **Quarkus** project illustrates how to use QuickPerf with **JUnit 5** for SQL annotations only. 

- [Open the org.quickperf.quarkus.quarkustest.service.PlayerServiceTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fquarkus%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fquarkus%2Fquarkustest%2Fservice%2FPlayerServiceTest.java)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Quarkus%20N%2B1%20select)
- [Open the org.quickperf.quarkus.quarkustest.controller.PlayerControllerTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fquarkus%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fquarkus%2Fquarkustest%2Fcontroller%2FPlayerControllerTest.java)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Quarkus%20http%20test)
