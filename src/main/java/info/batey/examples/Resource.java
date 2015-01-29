package info.batey.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Resource.class);

    @Autowired
    private ScaryDependency scaryDependency;

    @RequestMapping("/scary")
    public String callTheScaryDependency() {
        LOGGER.info("Resource later: I wonder which thread I am on!");
        return scaryDependency.getScaryString();
    }
}
