# Spring Boot + AOP + MDC (Mapped Diagnostic Context) Tutorial

To build:

```
> ./gradlew clean build
```

Then to run:
```
> java -jar build/libs/hello-springboot-mdc-0.1.0.jar
```

or combined:
```
./gradlew clean build && java -jar build/libs/hello-springboot-mdc-0.1.0.jar
```

To test:

http://localhost:8080/greeting

Or with name parameter:

http://localhost:8080/greeting?name=foo

To see the provided endpoints:

http://localhost:8080/mappings

### The AOP part
Review the sample Spring Boot + AOP project here: https://github.com/gapperdan/hello-springboot-aop
AOP will be configured to generate a random uuid to be used as the reference id in the log whenever a controller method is called (basically, a request to the /greeting endpoint)

### The MDC part
* MDC = Mapped Diagnostic Context (more details: http://logback.qos.ch/manual/mdc.html)
* Logging is configured to use logback 
* The logging configuration file is in _src/main/resources/logback-spring.xml_
* In the log configuration, note in the pattern where the MDC key will be written _(refId=%X{refId})_:
```
<pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} | refId=%X{refId} | %msg%n
```
* The AspectConfig class is configured to put the MDC key, _refId_ (in this sample, the first 10 characters of a random UUID) at the beginning of a method call in any controller class
* At the end of the same method call, the MDC key will be removed so a new key will be generated for the next request
* For every request (which means, the controller method is called), the generated UUID will be used as a reference id (refId) in the log automatically
```
...
refId=a4f6e75b486f | event=request received, nameParameter=foo
refId=a4f6e75b486f | action=generating random UUID
refId=a4f6e75b486f | event=request completed
...
```