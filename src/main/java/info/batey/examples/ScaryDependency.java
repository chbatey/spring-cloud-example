package info.batey.examples;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ScaryDependency {

    @HystrixCommand(fallbackMethod = "safeString")
    public String getScaryString() {
        if (System.currentTimeMillis() % 2 == 0) {
            return "Scary String";
        } else {
            throw new RuntimeException("Oh dear, the scary string got me");
        }
    }

    public String safeString() {
        return "Safe as houses";
    }
}
