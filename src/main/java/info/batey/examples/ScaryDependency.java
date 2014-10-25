package info.batey.examples;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ScaryDependency {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ScaryDependency.class);
    
    @HystrixCommand(fallbackMethod = "safeString")
    public String getScaryString() {
        LOGGER.info("Scary Dependency: I wonder which thread I am on! I assume it is a container thread :P");
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
