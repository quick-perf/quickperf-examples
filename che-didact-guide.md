<div align="center">
<img src="https://pbs.twimg.com/profile_banners/926219963333038086/1518645789" alt="QuickPerf"/>
</div>

# Welcome to the QuickPerf examples guide
This guide contains several projects showing how to use QuickPerf [JVM](https://github.com/quick-perf/doc/wiki/JVM-annotations) and [SQL](https://github.com/quick-perf/doc/wiki/SQL-annotations) annotations with various frameworks (*JUnit 4*, *JUnit 5*, *TestNG*, *Testcontainers*, *Spring Boot*, *Quarkus*, *Micronaut*, ...).

The guide is interactif, you can click on the bellow links to open files or start the predefined commands.

Powered by [Eclipse Che](https://www.eclipse.org/che/) and [VSCode Didact](https://github.com/redhat-developer/vscode-didact).

Enjoy!

## JVM annotations

**jvm-junit4**<br>
Examples showing how to use some **JVM annotations** with **JUnit 4**

- [Open the org.quickperf.jvm.JvmAnnotationsJunit4Test class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fjvm-junit4%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fjvm%2FJvmAnnotationsJunit4Test.java&number=2)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=JvmAnnotationsJunit4Test.java)
- [Kick off the test @MeasureHeapAllocation](didact://?commandId=workbench.action.tasks.runTask&text=JvmAnnotationsJunit4Test.java%20%2F%20%40MeasureHeapAllocation)

**jvm-junit5**<br>
Examples showing how to use some **JVM annotations** with **JUnit 5**

- [Open the org.quickperf.jvm.JvmAnnotationsJunit5Test class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fjvm-junit5%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fjvm%2FJvmAnnotationsJunit5Test.java&number=2)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=JvmAnnotationsJunit5Test.java)
- [Kick off the test @MeasureHeapAllocation](didact://?commandId=workbench.action.tasks.runTask&text=JvmAnnotationsJunit5Test.java%20%2F%20%40MeasureHeapAllocation)

**jvm-testng**<br>
Examples showing how to use some **JVM annotations** with **TestNG**

- [Open the org.quickperf.jvm.JvmAnnotationsTestNGTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fjvm-testng%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fjvm%2FJvmAnnotationsTestNGTest.java&number=2)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=JvmAnnotationsTestNGTest.java)
- [Kick off the test @MeasureHeapAllocation](didact://?commandId=workbench.action.tasks.runTask&text=JvmAnnotationsTestNGTest.java%20%2F%20%40MeasureHeapAllocation)


## Hibernate without Spring

**hibernate-junit4**<br>
Examples showing how to use some SQL annotations with **Hibernate** and **JUnit 4**

- [Open the org.quickperf.sql.HibernateJUnit4Test class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fhibernate-junit4%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fsql%2FHibernateJUnit4Test.java&number=2)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Hibernate%20JUnit%204)

**hibernate-junit5**<br>
Examples showing how to use some SQL annotations with **Hibernate** and **JUnit 5**

**hibernate-postgresql-testcontainers-junit5**<br>
Examples showing how to use some SQL annotations with **Hibernate**, **JUnit 5**, **PostgreSQL** and [**Testcontainers**](https://www.testcontainers.org)

**hibernate-mariadb-testcontainers-junit5**<br>
Examples showing how to use some SQL annotations with **Hibernate**, **JUnit 5**, **MariaDB** and [**Testcontainers**](https://www.testcontainers.org)

- [Open the org.quickperf.sql.HibernateJUnit5Test class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fhibernate-junit5%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fsql%2FHibernateJUnit5Test.java&number=2)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Hibernate%20JUnit%205)

**hibernate-testng**<br>
Examples showing how to use some SQL annotations with **Hibernate** and **TestNG**

- [Open the org.quickperf.sql.HibernateTestNGTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fhibernate-testng%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fsql%2FHibernateTestNGTest.java&number=2)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Hibernate%20TestNG)

## Spring Boot
**springboot-junit4**<br>
This **Spring Boot** project illustrates how to use QuickPerf with **JUnit 4** 

- [Open the football.controller.PlayerControllerTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fspringboot-junit4%2Fsrc%2Ftest%2Fjava%2Ffootball%2Fcontroller%2FPlayerControllerTest.java&number=2)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Spring%20Boot%20Contoller%20JUnit%204)
- [Open the football.service.PlayerServiceTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fspringboot-junit4%2Fsrc%2Ftest%2Fjava%2Ffootball%2Fservice%2FPlayerServiceTest.java&number=2)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Spring%20Boot%20Service%20JUnit%204)
- [Open the football.repository.PlayerRepositoryTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fspringboot-junit4%2Fsrc%2Ftest%2Fjava%2Ffootball%2Frepository%2FPlayerRepositoryTest.java&number=2)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Spring%20Boot%20Repository%20JUnit%204)


**springboot-junit5**<br>
This **Spring Boot** project illustrates how to use QuickPerf with **JUnit 5**

- [Open the football.controller.PlayerControllerTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fspringboot-junit5%2Fsrc%2Ftest%2Fjava%2Ffootball%2Fcontroller%2FPlayerControllerTest.java&number=2)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Spring%20Boot%20Contoller%20JUnit%205)
- [Open the football.service.PlayerServiceTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fspringboot-junit5%2Fsrc%2Ftest%2Fjava%2Ffootball%2Fservice%2FPlayerServiceTest.java&number=2)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Spring%20Boot%20Service%20JUnit%205)
- [Open the football.repository.PlayerRepositoryBatchTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fspringboot-junit5%2Fsrc%2Ftest%2Fjava%2Ffootball%2Frepository%2FPlayerRepositoryBatchTest.java&number=2)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Spring%20Boot%20Repository%20Batch%20JUnit%205)
- [Open the football.repository.PlayerRepositorySelectTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fspringboot-junit5%2Fsrc%2Ftest%2Fjava%2Ffootball%2Frepository%2FPlayerRepositorySelectTest.java&number=2)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Spring%20Boot%20Repository%20Select%20JUnit%205)


**testcontainers-springboot-junit5**<br>
This **Spring Boot** project illustrates how to use QuickPerf with **JUnit 5** and [**Testcontainers**](https://www.testcontainers.org)


## Micronaut
**micronaut-hibernate-jpa**<br>
This **Micronaut/Hibernate/JPA** project illustrates how to use QuickPerf with **JUnit 5** 



**micronaut-data-jdbc**<br>
This **Micronaut/Data JDBC** project illustrates how to use QuickPerf with **JUnit 5**. 

- [Open the org.quickperf.micronaut.micronauttest.service.PlayerServiceTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fmicronaut-data-jdbc%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fmicronaut%2Fmicronauttest%2Fservice%2FPlayerServiceTest.java&number=2)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Micronaut%20Data%20N%2B1%20select)
- [Open the org.quickperf.micronaut.micronauttest.controller.PlayerControllerTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fmicronaut-data-jdbc%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fmicronaut%2Fmicronauttest%2Fcontroller%2FPlayerControllerTest.java&number=2)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Micronaut%20Data%20HTTP)



## Quarkus
**quarkus**<br>
This **Quarkus** project illustrates how to use QuickPerf with **JUnit 5** for SQL annotations only. 

- [Open the org.quickperf.quarkus.quarkustest.service.PlayerServiceTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fquarkus%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fquarkus%2Fquarkustest%2Fservice%2FPlayerServiceTest.java&number=2)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Quarkus%20N%2B1%20select)
- [Open the org.quickperf.quarkus.quarkustest.controller.PlayerControllerTest class](didact://?commandId=vscode.open&projectFilePath=quickperf-examples%2Fquarkus%2Fsrc%2Ftest%2Fjava%2Forg%2Fquickperf%2Fquarkus%2Fquarkustest%2Fcontroller%2FPlayerControllerTest.java&number=2)
- [Kick off the test](didact://?commandId=workbench.action.tasks.runTask&text=Quarkus%20http%20test)

