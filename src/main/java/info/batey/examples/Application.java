package info.batey.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableHystrix
@RestController
@EnableHystrixDashboard
public class Application {

    @Autowired
    private ScaryDependency scaryDependency;

    @RequestMapping("/scary")
    public String home() {
        return scaryDependency.getScaryString();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
