<h1 align="center">Java Unit Testing with JUnit</h1>

## Adding JUnit to Your Project

For Maven projects, add the following dependency to your pom.xml file:

```xml

<dependencies>
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
  </dependency>

  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```

Or you can find the latest version of
JUnit [here](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api).

<br />

## Generate Code Coverage Report Using Surefire and Jacoco

```xml

<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-surefire-plugin</artifactId>
      <version>3.1.2</version>
      <configuration>
        <statelessTestsetReporter
          implementation="org.apache.maven.plugin.surefire.extensions.junit5.JUnit5Xml30StatelessReporter">
          <!-- Show @DisplayName -->
          <usePhrasedTestCaseMethodName>true</usePhrasedTestCaseMethodName>
        </statelessTestsetReporter>
        <!-- Allow Failure Cases -->
        <testFailureIgnore>true</testFailureIgnore>
      </configuration>
    </plugin>

    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-surefire-report-plugin</artifactId>
      <version>3.1.2</version>
      <executions>
        <execution>
          <phase>test</phase>
          <goals>
            <goal>report</goal>
          </goals>
        </execution>
      </executions>
    </plugin>

    <plugin>
      <groupId>org.jacoco</groupId>
      <artifactId>jacoco-maven-plugin</artifactId>
      <version>0.8.10</version>
      <executions>
        <execution>
          <id>jacoco-prepare</id>
          <goals>
            <goal>prepare-agent</goal>
          </goals>
        </execution>
        <execution>
          <id>jacoco-report</id>
          <phase>test</phase>
          <goals>
            <goal>report</goal>
          </goals>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
```

Then run the following command to generate the report:

```bash
# Run the unit tests
mvn clean test

# Generate the report, site -> add website resources images, css etc. -DgenerateReports=false -> don't overwrite the existing reports
mvn site -DgenerateReports=false
```