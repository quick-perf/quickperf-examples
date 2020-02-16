<div align="center">
<img src="https://pbs.twimg.com/profile_banners/926219963333038086/1518645789" alt="QuickPerf"/>
</div>

# QuickPerf examples

This repository contains several projects showing how to use **[QuickPerf](https://github.com/quick-perf/quickperf)** with various frameworks (JUnit 4, JUnit 5, TestNG, Spring Boot, Micronaut, ...).

# 🚩 Table of contents
[How to run the examples](#How-to-run-the-examples) <br><br>
[JVM annotations](#JVM-annotations) <br><br>
[Spring Boot](#Spring-Boot) <br><br>
[Micronaut](#Micronaut)

## How to run the examples
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
  ./mvnw clean install compile
```

Import the _quickperf-examples_ project in your IDE.

You can now execute the test methods from your IDE.

## JVM annotations

The documentation of JVM annotation is [here](https://github.com/quick-perf/doc/wiki/JVM-annotations).

**[jvm-junit4](jvm-junit4)**<br>
Examples showing how to use some JVM annotations with **JUnit 4**.

**[jvm-junit5](jvm-junit5)**<br>
Examples showing how to use some JVM annotations with **JUnit 5**.

**[jvm-testng](jvm-testng)**<br>
Examples showing how to use some JVM annotations with **TestNG**.

## Spring Boot
**[springboot-junit4](springboot-junit4)**<br>
This Spring Boot project illustrates how to use QuickPerf with **JUnit 4**. 

**[springboot-junit5](springboot-junit5)**<br>
This Spring Boot project illustrates how to use QuickPerf with **JUnit 5**. 

## Micronaut
**[micronaut-hibernate-jpa](micronaut-hibernate-jpa)**<br>
This Micronaut/Hibernate/JPA project illustrates how to use QuickPerf with **JUnit 5**. 