Simple Spring Cloud Netflix example
====================

To get going:

```
mvn package
java -jar ./target/spring-cloud-example-0.0.1-SNAPSHOT.jar
```

Then to execute the resource to go [scary](http://localhost:8080/scary).

You should see some logs to prove the call to the scary dependency is on a different thread:

```
00:15:59.367 [http-nio-8080-exec-3] INFO  info.batey.examples.Resource - Resource later: I wonder which thread I am on!
00:15:59.499 [hystrix-ScaryDependency-1] INFO  info.batey.examples.ScaryDependency - Scary Dependency: I wonder which thread I am on! I assume it is a container thread :P
```

To see a hystrix dash board go to:

[Hystrix Dashboard](http://localhost:8080/hystrix/index.html)

And enter the following URL: http://localhost:8080/hystrix.stream e.g

<img src="https://raw.githubusercontent.com/chbatey/spring-cloud-example/master/hystrix-welcome.png" />

You should see something like:

<img src="https://raw.githubusercontent.com/chbatey/spring-cloud-example/master/hystrix.png" />

Which shows how often the call to scary string timed out / failed etc

