# VKBot

Bot for Vk groups that quotes the text it is being messaged

#### Requirements
[JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

#### How to run application
##### 1. Download source code from Git repository
##### 2. Extract files from zip archive
##### 3. Setup VK API properties
> 1. Open `src/main/resources/vk.properties`
> 2. Specify parameters gotten from VK
>    
> | Variable name       | Description                      |
> |---------------------|----------------------------------|
> | vk.api.access-token | VK API access token              |
> | vk.api.v            | VK API usage version             |
> | vk.api.secret       | Callback API secret key          |
> | vk.api.confirmation | Callback API confirmation string |
##### 4. Build jar
> On Linux host:
> ```
> ./mvnw clean package
> ```
>
> On Windows host:
> ```
> .\mvnw.cmd clean package
> ```
 ##### 5. Run application with java
```
java -jar target/VKBot-0.0.1-SNAPSHOT.jar
```
