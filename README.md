maven-coveralls-plugin
======================

[![Build Status](https://travis-ci.org/trautonen/coveralls-maven-plugin.png?branch=master)](https://travis-ci.org/trautonen/coveralls-maven-plugin)
[![Coverage Status](https://coveralls.io/repos/trautonen/coveralls-maven-plugin/badge.png?branch=master)](https://coveralls.io/r/trautonen/coveralls-maven-plugin?branch=master)

Maven plugin for submitting Java code coverage reports to [Coveralls](https://coveralls.io/) web
service.


### Features

* Supports [JaCoCo](http://www.eclemma.org/jacoco/trunk/doc/maven.html) and
  [Cobertura](http://mojo.codehaus.org/cobertura-maven-plugin/) coverage tools
* Fully streaming implementation for fast report generation and small memory footprint
* Provides clean interfaces to allow easy extending to different coverage tools
* Convention over configuration for almost zero configuration usage


### Usage

Set up the Coveralls maven plugin in the build section of the project pom.xml:

```xml
<plugin>
    <groupId>org.eluder.coveralls</groupId>
    <artifactId>coveralls-maven-plugin</artifactId>
    <version>1.1.0</version>
    <configuration>
        <repoToken>yourcoverallsprojectrepositorytoken</repoToken>
    </configuration>
</plugin>
```

#### Configuration

If used as a standalone maven build or with any continuous integration server other than Travis
CI, the Coveralls repository token must be provided. This can be achieved by setting the
configuration section in the plugin or setting a system property for VM using
`-DrepoToken=yourcoverallsprojectrepositorytoken` when running the maven command. **Do not publish
your repository token in public GitHub repositories.**

With Travis CI you need to provide only service name either via plugin configuration or system
property. The corresponding configuration value is `-DserviceName=travis-ci`. Rest of the
configuration for Travis CI is handled internally by the plugin.


#### Cobertura

Set up the Cobertura maven plugin with XML report format in the build section of the project
pom.xml:

```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>cobertura-maven-plugin</artifactId>
    <version>2.5.2</version>
    <configuration>
        <format>xml</format>
        <maxmem>256m</maxmem>
    </configuration>
</plugin>
```

Execute maven to create Cobertura report and submit Coveralls data:

```
mvn cobertura:cobertura coveralls:cobertura
```


#### JaCoCo

Set up the JaCoCo maven plugin in the build section of the project pom.xml:

```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.6.3.201306030806</version>
    <executions>
        <execution>
            <id>prepare-agent</id>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

Execute maven to create JaCoCo report and submit Coveralls data:

```
mvn test jacoco:report coveralls:jacoco
```


### Continuous integration

Travis CI builds the plugin with Oracle JDK 7. All successfully built snapshots are deployed to
Sonatype OSS repository. Cobertura is used to gather coverage metrics and the report is submitted
to Coveralls with this plugin.


### License

The project coveralls-maven-plugin is licensed under the MIT license.
