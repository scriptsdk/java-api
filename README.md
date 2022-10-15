## Summary

Stealth Client is an alternative Ultima Online client written in Delphi and distributed on their [website](https://stealth.od.ua/ "website"). Stealth exposes a socket based external api which is subject of this project.

ScriptSDK.Api is an implementation of external api. It includes all kind of functions and events to communicate with Stealth. 

### Requirements

- [Lombok](https://projectlombok.org/ "Lombok")

- [OpenJDK 17](https://adoptium.net/ "OpenJDK 17") 

- [Access to scriptsdk.core](https://github.com/stealth-scriptsdk/java-core "Access to scriptsdk.core")

## Features

- Implementation of ApiClient including 422 methods & events
- Implementation of generic api test suite for 418 methods & events

### Excluded methods

- CLEAR_FIGURES
- REMOVE_FIGURE
- ADD_FIGURE
- MESSENGER_GET_CONNECTED
- MESSENGER_SET_CONNECTED
- MESSENGER_GET_TOKEN
- MESSENGER_SET_TOKEN
- MESSENGER_GET_NAM
- MESSENGER_SEND_MESSAGE
- GET_MULTI_ALL_PARTS
- GET_MULTI_PARTS_AT_POSITION
- HTTP_GET
- HTTP_POST
- HTTP_BODY
- HTTP_HEADER

### Excluded test methods
- stopScript
- stopAllScripts
- setTimer1Event
- setTimer2Event

## Installation

### 🛠 Use source code

Developers can fork this repository and use it as it is for their own forks or implementations. Even thought its possible to directly use the sourcecode as base, its recommned to implement this project as maven package.

### 📦 Use as maven package

In order to use Github maven repositories, developers must be registered at github and being able to create a [personal access token](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token "personal access token").

As next step the personal access token must be usable through local maven repository by adding a **Settings.xml** to local .m2 folder. This is regulary located at **C:\Users\USER\.m2\**

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 https://maven.apache.org/xsd/settings-1.0.0.xsd">
<servers>
    <server>
        <id>github</id>
        <username>USERNAME</username>
        <password>AUTH_TOKEN</password>
    </server>
</servers>
</settings>
```

The last step is adding references to package repository to pom.xml file.

```xml
    <repositories>
        <repository>
            <id>github</id>
            <name>GitHub ScriptSDK Java Core</name>
            <url>https://maven.pkg.github.com/stealth-scriptsdk/java-api</url>
            <releases><enabled>true</enabled></releases>
            <snapshots><enabled>false</enabled></snapshots>
        </repository>
    </repositories>
```



```xml
<dependency>
  <groupId>de.scriptsdk</groupId>
  <artifactId>api</artifactId>
  <version>1.0.0</version>
</dependency>
```
